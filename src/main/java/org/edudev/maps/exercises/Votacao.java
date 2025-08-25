package org.edudev.maps.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Votacao {

    void main() {
        final var data = new String[]{
                "Alex Blue,15",
                "Maria Green,22",
                "Bob Brown,21",
                "Alex Blue,30",
                "Bob Brown,15",
                "Maria Green,27",
                "Maria Green,22",
                "Bob Brown,25",
                "Alex Blue,31"

        };

        System.out.println(counting(data));
        System.out.println();
        System.out.println(counting2(data));
        System.out.println();
        System.out.println(counting3(data));
    }

    public List<String> counting(final String[] votes) {
        final Map<String, Integer> candidatePerVotes = new HashMap<>();
        final List<String> result = new ArrayList<>();

        for (var i = 0; i < votes.length; i++) {
            final var data = votes[i].split(",");
            final var name = data[0];
            final var totalVotes = Integer.valueOf(data[1]);

            final var value = candidatePerVotes.get(name);
            if (value != null) {
                candidatePerVotes.put(name, value + totalVotes);
            } else {
                candidatePerVotes.put(name, totalVotes);
            }
        }

        for (var entry : candidatePerVotes.entrySet()) {
            result.add(STR."\"\{entry.getKey()},\{entry.getValue()}\"");
        }

        return result;
    }

    public List<String> counting2(final String[] votes) {
        final Map<String, Integer> candidatePerVotes = new HashMap<>();
        final List<String> result = new ArrayList<>();

        for (final String vote : votes) {
            final var data = vote.split(",");
            final var name = data[0];
            final var totalVotes = Integer.valueOf(data[1]);

            candidatePerVotes.merge(name, totalVotes, Integer::sum);
        }

        for (var entry : candidatePerVotes.entrySet()) {
            result.add(STR."\"\{entry.getKey()},\{entry.getValue()}\"");
        }

        return result;
    }

    public List<String> counting3(final String[] votes) {
        final Map<String, Integer> candidatePerVotes = new HashMap<>();

        Arrays.stream(votes)
                .map(vote -> vote.split(","))
                .forEach(data -> {
                    final var name = data[0];
                    final var totalVotes = Integer.valueOf(data[1]);
                    candidatePerVotes.merge(name, totalVotes, Integer::sum);
                });

        return candidatePerVotes.entrySet()
                .stream()
                .map(entry -> STR."\"\{entry.getKey()},\{entry.getValue()}\"")
                .toList();
    }

}
