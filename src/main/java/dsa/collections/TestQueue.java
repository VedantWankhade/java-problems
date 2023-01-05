package dsa.collections;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>(); // use linkedlist as a queue
        queue.offer("ASDASD");
        queue.offer("ridfg");
        queue.offer("IKADShf");
        queue.offer("SADASDk");

        while (queue.size() > 0) {
            System.out.println(queue.remove() + " ");
        }
    }
}
