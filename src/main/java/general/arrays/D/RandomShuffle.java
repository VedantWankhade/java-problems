package general.arrays.D;

import java.util.Arrays;

public class RandomShuffle {
    public static void shuffle(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int newIndex = (int) (Math.random() * 5);
            // swwap
            System.out.println(arr[i] + " <=> " + arr[newIndex]);
            arr[newIndex] = (arr[i] + arr[newIndex]) - (arr[i] = arr[newIndex]);
            System.out.println(arr[i] + " <=> " + arr[newIndex]);
        }
    }

    public static void main(String[] args) {
        int[] arr = GenerateArrayWithRandomInts.getArrayOfRandomInts(5, 5);
        System.out.println(Arrays.toString(arr));
        shuffle(arr);
        System.out.println("--------Shuffled-------");
        System.out.println(Arrays.toString(arr));
    }
}
