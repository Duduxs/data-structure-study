package org.edudev.sets.exercises;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import static java.util.stream.Collectors.toSet;

final class Visitantes {

    void main() {
        try (final var file = new FileInputStream("src/main/resources/visitantes-input.json")) {

            final var mapper = new ObjectMapper();
            List<String> visitors = mapper.readValue(file, List.class);
            List<String> visitors2 = List.of(
                    "ana,2024-07-04T21:42:40.353283800Z,https://blog.com/login",
                    "bob,2024-07-04T21:42:44.571283800Z,https://blog.com/news",
                    "maria,2024-07-04T21:42:46.394283800Z,https://blog.com/shop",
                    "ana,2024-07-04T21:42:50.026283800Z,https://blog.com/news"

            );

            System.out.println(total(visitors));
            System.out.println(total(visitors2));

        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int total(List<String> visitors) {
        return visitors.stream().map(x -> x.split(",")[0]).collect(toSet()).size();
    }

}
