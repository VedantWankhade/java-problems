package generics;

public class MaxUsingGenerics {
    public static <E extends Comparable<E>> E max(E o1, E o2) {
        if (o1.compareTo(o2) > 0) return o1;
        return o2;
    }
}
