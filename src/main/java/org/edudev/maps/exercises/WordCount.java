package org.edudev.maps.exercises;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Rank {
    final String word;
    final Integer count;

    public Rank() {
        this(null, null);
    }

    public Rank(final Map.Entry<String, Integer> entry) {
        this(entry.getKey(), entry.getValue());
    }

    public Rank(final String uorde, final Integer temp) {
        this.word = uorde;
        this.count = temp;
    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return STR."\{word}: \{count}";
    }
}

public class WordCount {

    void main() {
        final var text = normalize("""
                O vento sussurra sons entre as árvores, sons que fazem animais correrem.
                A floresta e a natureza vibram com segredos e sons.
                """);

        wordCount(text).forEach(System.out::println);

    }

    public static List<Rank> wordCount(final String text) {
        final Map<String, Integer> map = new HashMap<>();
        final String[] words = text.split(" ");
        final List<Rank> result = new ArrayList<>();

        for (final String word : words) {
            map.merge(word, 1, Integer::sum);
        }

        for (final Entry<String, Integer> entry : map.entrySet()) {
            result.add(new Rank(entry));
        }

        final var collator = Collator.getInstance(Locale.getDefault());

        result.sort(Comparator
                .comparing(Rank::getCount, Comparator.reverseOrder())
                .thenComparing((r1, r2) -> collator.compare(r1.word, r2.word))
        );

/*
    Segunda forma de ordenação
        result.sort((r1, r2) -> {
            var countComparison = r2.temp - r1.temp;
            if (countComparison != 0) return countComparison;
            return collator.compare(r1.uorde, r2.uorde);
        });*/

        return result;
    }

    public static String normalize(String text) {
        Pattern pattern = Pattern.compile("[^\\p{L}\\p{N}\\s]", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        String words = matcher.replaceAll(" ");
        return words.replaceAll("\\s+", " ").trim().toLowerCase();
    }

}
