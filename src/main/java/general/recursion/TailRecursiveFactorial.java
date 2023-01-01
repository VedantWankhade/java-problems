package general.recursion;

public class TailRecursiveFactorial {
    public static long factorial(int n) {
        return factorial(n, 1);
    }

    private static long factorial(int n, int result) {
        if (n == 0) return result;
        return factorial(n - 1, n * result);
    }
}
