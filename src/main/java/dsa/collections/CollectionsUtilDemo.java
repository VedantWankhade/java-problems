package dsa.collections;

import java.util.*;

public class CollectionsUtilDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("red", "green", "blue"));
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        // reverse order - Collections.reverseOrder() returns a Comparator object
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);


        List<Integer> list1 = Arrays.asList(2, 4, 7, 50, 59, 60, 10, 45, 66);
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);
        // binary search
        System.out.println("index of 7: " + Collections.binarySearch(list1, 7));
        System.out.println("9 not present, index of 9 should be : " + Collections.binarySearch(list1, 9));

        list.add("yellow");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);


        // passing an object of Random with same seed will shuffle in the same way
        List<String> list2 = (List<String>)((ArrayList<String>) list).clone();
        Collections.sort(list);
        Collections.sort(list2);

        Collections.shuffle(list, new Random(10));
        Collections.shuffle(list2, new Random(10));
        System.out.println(list + " " + list2);

        // with different seed
        Collections.shuffle(list, new Random(10));
        Collections.shuffle(list2, new Random(20));
        System.out.println(list + " " + list2);


        // NOTE
        // if you create a list using Arrays.asList() like
        List<Integer> list4 = Arrays.asList(1, 5, 6, 7);
        // then you cannot add() or remove()
        // two lines below compile but throw UnsupportedOperation at runtime
//        list4.add(45);
//        list4.remove(6);

        // these work fine
        list4.set(1, 10);
        // and others

        // this is because the ArrayList returned by Arrays.asList is not the same as java.util.ArrayList
        // Arrays.asList returned a custom ArrayList implementation present in Arrays class


        List<String> list3 = list;
        List<String> list5 = Arrays.asList("White", "black");
        Collections.copy(list3, list5); // (dest, src)

        // nCopies(int n, Object o) creates an immutable list of n o's
        List<Integer> list6 = Collections.nCopies(5, 99);
        System.out.println(list6);

        // WARNING: all the elements created by Collections.nCopies have the same reference
        // example below - chanign any element result a change in others too
        List<StringBuilder> list7 = Collections.nCopies(5, new StringBuilder("Hello"));
        System.out.println(list7);
        list7.get(0).append("VVVVVVVV");
        System.out.println(list7);

        // Collections.fill(list, object) replaces all the elements in list with object
        System.out.println(list);
        Collections.fill(list, "BLACK");
        System.out.println(list);
    }
}
