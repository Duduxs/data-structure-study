package org.edudev.queues.exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class TimeNeededToBuyTickets {

    public void main() {
        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
        System.out.println("----------------------");
        System.out.println(timeRequiredToBuy2(new int[]{2, 3, 2}, 2));
        System.out.println(timeRequiredToBuy2(new int[]{5, 1, 1, 1}, 0));
        System.out.println("----------------------");
        System.out.println(timeRequiredToBuy3(new int[]{2, 3, 2}, 2));
        System.out.println(timeRequiredToBuy3(new int[]{5, 1, 1, 1}, 0));
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        var count = 0;

        for (var i = 0; i < tickets.length; i++) {
            map.put(i, tickets[i]);
        }

        for (var i = 0; map.get(k) != 0; i++) {

            if (i == map.size()) {
                i = 0;
            }

            var element = map.getOrDefault(i, 0);

            if (element == 0) {
                continue;
            }

            map.put(i, --element);
            count++;
        }

        return count;
    }

    public int timeRequiredToBuy2(int[] tickets, int k) {
        var i = 0;
        var count = 0;

        while (true) {
            if (i == tickets.length) i = 0;
            var element = tickets[i];

            if (element == 0) {
                i++;
                continue;
            }

            tickets[i++] -= 1;
            count++;

            if (tickets[k] == 0) {
                break;
            }

        }

        return count;
    }

    public int timeRequiredToBuy3(int[] tickets, int k) {
        final Deque<Integer> queue = new ArrayDeque<>();
        var count = 0;

        for (var i = 0; i < tickets.length; i++) {
            queue.add(i);
        }

        while (tickets[k] != 0) {
            final var index = queue.pop();

            tickets[index]--;

            if (tickets[index] != 0) {
                queue.addLast(index);
            }

            count++;
        }

        return count;
    }


}
