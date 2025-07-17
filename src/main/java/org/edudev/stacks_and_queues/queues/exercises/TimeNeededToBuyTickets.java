package org.edudev.stacks_and_queues.queues.exercises;

import java.util.HashMap;
import java.util.Map;

public class TimeNeededToBuyTickets {

    public void main() {
        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(timeRequiredToBuy(new int[]{5,1,1,1}, 0));
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
}
