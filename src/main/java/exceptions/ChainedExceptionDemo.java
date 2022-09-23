package exceptions;

public class ChainedExceptionDemo {
    public static void main(String[] args) {
        try {
            meth1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void meth1() throws Exception {
        try {
            meth2();
        } catch (Exception e) {
            System.out.println("HELLO");
            throw new Exception("Exception from METH1");
        }
    }

    public static void meth2() throws Exception {
        throw new Exception("Exception from Method2");
    }
}
