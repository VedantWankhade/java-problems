package generics;

public class WhyNeedWildcard {
    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);

//        System.out.println("The max number is " + max(intStack));
    }

//    public static double max(GenericStack<Number> stack) {
//        // logic to find max
//        // but it doesnt work as GenericStack<Number> is not a supertype of GenericStack<Integer> even though Number is supertype of Integer
//        return 0.1;
//    }

    public static <T extends Number> double max1(GenericStack<T> stack) {
        //logic to fid max
        // this one works but looks wierd
        return 0.2;
    }

    public static double max2(GenericStack<? extends Number> stack) { // this takes stack of any class that is subclass of Number
        // this works and looks better
        return 0.1;
    }

    public static double max3(GenericStack<?> stack) { // takes stack of any class (that extends Object)
        return -23;
    }
}
