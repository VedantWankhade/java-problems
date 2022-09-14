package general.arrays.D;

import java.util.Arrays;

public class CopyArray {

    public static void main(String[] args) {

        int[] testArr;

        int[] arr = GenerateArrayWithRandomInts.getArrayOfRandomInts(5, 5);
        
        // using Object.clone()
        testArr = arr.clone();
        System.out.println(Arrays.toString(arr) + " <==> " + Arrays.toString(testArr));

        int[] testArr2 = new int[9];

        // using System.arraycopy
        // NOTE: The arraycopy method violates the Java naming convention. By convention, this
        //method should be named arrayCopy (i.e., with an uppercase C).
        System.arraycopy(arr, 0, testArr2, 0, 5);
        System.out.println(Arrays.toString(arr) + " => " + Arrays.toString(testArr2));
    }

}
