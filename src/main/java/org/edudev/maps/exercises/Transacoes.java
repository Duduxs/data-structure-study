package org.edudev.maps.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transacoes {

    void main() {
        invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,100,beijing"}).forEach(System.out::println);
        System.out.println();
        invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,1200,mtv"}).forEach(System.out::println);
        System.out.println();
        invalidTransactions(new String[]{"alice,20,800,mtv", "bob,50,1200,mtv"}).forEach(System.out::println);
        System.out.println();
        System.out.println();
        invalidTransactions2(new String[]{"alice,20,800,mtv", "alice,50,100,beijing"}).forEach(System.out::println);
        System.out.println();
        invalidTransactions2(new String[]{"alice,20,800,mtv", "alice,50,1200,mtv"}).forEach(System.out::println);
        System.out.println();
        invalidTransactions2(new String[]{"alice,20,800,mtv", "bob,50,1200,mtv"}).forEach(System.out::println);

    }

    public static List<String> invalidTransactions(final String[] transactions) {

        final class Transaction {

            public String name;
            public int time;
            public int amount;
            public String city;
            public String csv;

            public Transaction(final String entry) {
                final var values = entry.split(",");
                name = values[0];
                time = Integer.parseInt(values[1]);
                amount = Integer.parseInt(values[2]);
                city = values[3];
                csv = entry;
            }
        }

        final List<Transaction> allTransactions = new ArrayList<>();
        final Map<String, List<Transaction>> namePerTransactions = new HashMap<>();
        final List<String> result = new ArrayList<>();

        for (final var t : transactions) {
            final var transaction = new Transaction(t);

            allTransactions.add(transaction);

            final var getTransaction = namePerTransactions.get(transaction.name);

            if (getTransaction != null) {
                getTransaction.add(transaction);
                continue;
            }
            namePerTransactions.put(transaction.name, new ArrayList<>(List.of(transaction)));
        }

        for (final var t : allTransactions) {
            if (t.amount > 1000) {
                result.add(t.csv);
                continue;
            }

            for (final var t2 : namePerTransactions.get(t.name)) {
                if (Math.abs(t.time - t2.time) <= 60 && !t.city.equals(t2.city)) {
                    result.add(t.csv);
                    break;
                }
            }

        }

        return result;
    }

    public static List<String> invalidTransactions2(final String[] transactions) {
        final Map<String, List<String[]>> namePerTransactions = new HashMap<>();
        final List<String> result = new ArrayList<>();

        for (final var t : transactions) {
            final var splitTransaction = t.split(",");

            namePerTransactions.putIfAbsent(splitTransaction[0], new ArrayList<>());
            namePerTransactions.get(splitTransaction[0]).add(splitTransaction);
        }

        for (final var t : transactions) {
            final var splitTransaction = t.split(",");

            if (Integer.parseInt(splitTransaction[2]) > 1000) {
                result.add(t);
                continue;
            }

            for (var t2 : namePerTransactions.get(splitTransaction[0])) {
                if (Math.abs(Integer.parseInt(splitTransaction[1]) - Integer.parseInt(t2[1])) <= 60 && !splitTransaction[3].equals(t2[3])) {
                    result.add(t);
                    break;
                }
            }
        }

        return result;

    }
}
