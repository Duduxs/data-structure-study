package org.edudev.sets.exercises;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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

            var start = System.currentTimeMillis();
            System.out.println("> > > Totais usando conjuntos < < < ");
            System.out.println(total(visitors));
            System.out.println(total(visitors2));
            var end = System.currentTimeMillis();
            System.out.println(STR."> > > Totais usando conjuntos, tempo: \{formatDuration(end, start)} < < < "); // 32 MS com SET

            System.out.println();

            start = System.currentTimeMillis();
            System.out.println("> > > Totais SEM usar conjuntos < < < ");
            System.out.println(totalWithoutSet(visitors));
            System.out.println(totalWithoutSet(visitors2));
            end = System.currentTimeMillis();
            System.out.println(STR."> > > Totais SEM usar conjuntos, tempo: \{formatDuration(end, start)} < < < "); // 3s 192ms com LIST

        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int total(List<String> visitors) {
        return visitors.stream()
                .map(x -> x.split(",")[0])
                .collect(toSet())
                .size(); // Busca, inserção e deleção no conjunto no caso médio é Θ(1) <Ordem constante> [Theta de 1]
    }

    public static int totalWithoutSet(List<String> visitors) {
        final List<String> uniqueVisitors = new ArrayList<>();

        for (var visitor : visitors) {
            final var name = visitor.split(",")[0];
            if (!uniqueVisitors.contains(name)) { // Busca sequencial no contains O(N) <Ordem linear> [Big O de N] por ser uma lista. No caso médio é Θ(N).
                uniqueVisitors.add(name);
            }
        }

        return uniqueVisitors.size();
    }

    private static String formatDuration(final long end, final long start) {
        final long durationMs = end - start;
        final long minutes = durationMs / 60000;
        final long seconds = (durationMs % 60000) / 1000;
        final long millis = durationMs % 1000;
        return String.format("%dm %ds %dms", minutes, seconds, millis);
    }


}
