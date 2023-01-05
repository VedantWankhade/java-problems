package dsa.collections;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<String> q1 = new PriorityQueue<>();
        q1.offer("ABC");
        q1.offer("ASTRE");
        q1.offer("SFDGFRR");
        q1.offer("MNJKFJG");

        System.out.println("Priority queue using Comaprable: ");
        while (q1.size() > 0) System.out.println(q1.remove() + " ");

        PriorityQueue<String> q2 = new PriorityQueue<>(4, Collections.reverseOrder());
        q2.offer("ABC");
        q2.offer("ASTRE");
        q2.offer("SFDGFRR");
        q2.offer("MNJKFJG");
        System.out.println("Priority queue using Comparator: ");
        while (q2.size() > 0) System.out.println(q2.remove() + " ");
    }
}
