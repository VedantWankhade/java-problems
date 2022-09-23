package oop;

public class NumberWrappers {
    public static void main(String[] args) {
        // integers
        Integer a;
        Integer b;

        // creating Integer object
        a = new Integer(2);   // deprecated
        b = new Integer("2");    // deprecated

        a = 2;   // this also works
        b = Integer.valueOf("22");   // but this is more explicit

        int aInt = a; // this also works
        int bInt = b.intValue(); // this is more explicit


        int dInt = Integer.valueOf("22");   // this works
        int cInt = Integer.parseInt("22");  // but this is recommended

        // all the methods are similar for other Number types

        double d = a.doubleValue();
        double dd = (double) a;

        double d1 = 22.9;
        int i1 = (int) d1;
        Double d2 = Double.valueOf(d1);//

        int i2 = d2.intValue();

//        System.out.println(i1 + "\t" + i2);


        Integer ii1 = Integer.valueOf(22);
        Integer ii2 = Integer.valueOf(22);
        System.out.println(ii1 == ii2);


//        System.out.println(ii1 + "\t" + ii2);


        System.out.println("Long: " + Long.MAX_VALUE);
        System.out.println("Double: " + Double.MAX_VALUE);
//        System.out.println(d + "    " + dd);
//
//        System.out.println(Double.MAX_VALUE);
//        System.out.println(Double.MIN_VALUE);

    }
}
