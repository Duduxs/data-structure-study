package org.edudev.sets.exercises;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import static java.util.stream.Collectors.toSet;

final class Visitantes {

    void main() {
        try (final var file = new FileInputStream("src/main/resources/visitantes-input.json")) {

            final var mapper = new ObjectMapper();
            List<String> visitors = mapper.readValue(file, List.class);

            System.out.println(total(visitors));

        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int total(List<String> visitors) {
        return visitors.stream().map(x -> x.split(",")[0]).collect(toSet()).size();
    }

}
