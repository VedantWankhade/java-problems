package dsa.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hasMap = new HashMap<>();
        hasMap.put("ABC", 30);
        hasMap.put("CDE", 21);
        hasMap.put("XYZ", 29);
        hasMap.put("LMN", 29);

        System.out.println("Display entries in HashMap");
        System.out.println(hasMap + "\n");

        Map<String, Integer> treeMap = new TreeMap<>(hasMap);
        System.out.println("Displayt entries in ascending order of key");
        System.out.println(treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("ABC", 30);
        linkedHashMap.put("CDE", 21);
        linkedHashMap.put("XYZ", 29);
        linkedHashMap.put("LMN", 29);

        System.out.println("\nThe age for " + "XYZ is " + linkedHashMap.get("XYZ"));

        System.out.println("Display entries in LinkedHashMap");
        System.out.println(linkedHashMap);

        System.out.println("\nNames and ages are ");
        treeMap.forEach((name, age) -> System.out.print(name + ": " + age + " "));
    }
}
