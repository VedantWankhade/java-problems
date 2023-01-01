package generics;

public class GenericSortDemo {
    public static void main(String[] args) {
        Integer[] intArr = { new Integer(2), new Integer(4), new Integer(3) };

        Double[] doubleArr = { new Double(3.4), new Double(1.3), new Double(-22.1) };

        Character[] charArr = {new Character('a'),
                new Character('J'), new Character('r')};

        String[] stringArr = { "Tom", "Susan", "Kim" };

        sort(intArr);
        sort(doubleArr);
        sort(charArr);
        sort(stringArr);

        printList(intArr);
        printList(doubleArr);
        printList(charArr);
        printList(stringArr);
    }

    public static <E extends Comparable<E>> void sort(E[] list) {
        E currentMin;
        int currentMinIndex;

        for (int i = 0; i < list.length - 1; i++) {
            currentMin = list[i];
            currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static <E> void printList(E[] list) {
        for (E e: list) System.out.print(e + " ");
        System.out.println();
    }
}