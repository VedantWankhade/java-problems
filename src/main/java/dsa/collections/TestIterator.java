package dsa.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestIterator {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("New Yorkk");
        collection.add("Atlanta");
        collection.add("Dallas");
        collection.add("Madison");

        Iterator<String> iterator = collection.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // enhanced for loop uses iterator under the hood
        for(String s: collection) System.out.print(s + " ");

        // for each method also uses iterator under the hood
        collection.forEach(e -> System.out.print(e + " "));
        collection.forEach(System.out::print);

        collection.forEach(
                new java.util.function.Consumer<String>() {
                    @Override
                    public void accept(String e) {
                        System.out.print(e + " ");
                    }
                }
        );

    }
}
