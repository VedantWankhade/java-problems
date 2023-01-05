package dsa.collections;

import java.util.Set;
import java.util.TreeSet;

public class TestTreeSetWithComparator {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>((s1, s2) -> s1.length() - s2.length());
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Fransisco");
        set.add("Beijing");
        set.add("New York");

        System.out.println(set);
    }
}
