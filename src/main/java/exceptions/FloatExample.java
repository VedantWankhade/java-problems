package exceptions;

public class FloatExample {
    public static void main(String[] args) {
        float divisor1 = 0;

        System.out.println(22 / divisor1);
        // dividing by float 0 does not throw exception 😳
    }
}
