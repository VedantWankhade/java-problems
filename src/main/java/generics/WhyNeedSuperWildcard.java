package generics;

public class WhyNeedSuperWildcard {
    public static void main(String[] args) {
        GenericStack<String> s1 = new GenericStack<>();
        GenericStack<Object> s2 = new GenericStack<>();
        s2.push("Java");
        s2.push(2);
        s1.push("usn");
        add(s1, s2);
    }

    public static <T> void add(GenericStack<T> s1, GenericStack<? super T> s2) {
        while (!s1.isEmpty()) s2.push(s1.pop());
    }
}
