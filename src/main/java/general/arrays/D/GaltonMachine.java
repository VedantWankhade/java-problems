package general.arrays.D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GaltonMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of balls: ");
        int noOfBalls = in.nextInt();
        System.out.println("Enter the number of slots: ");
        int noOfSlots = in.nextInt();

        List<Integer> res = simulate(noOfBalls, noOfSlots);
        drawResult(res);
    }

    public static List<Integer> simulate(int noOfBalls, int noOfSlots) {
        System.out.println("Simulating for " + noOfBalls + " balls and " + noOfSlots + " slots");
        int noOfNails = (noOfSlots - 1) * noOfSlots / 2;
        System.out.println("[No of nails: " + noOfNails + "]");

        List<Integer> res = new ArrayList<>(Collections.nCopies(noOfSlots, 0));
//        System.out.println(res + " " + res.size());

        for (int i = 0; i < noOfBalls; i++) {
            int Rs = 0;
            String pos = "";
            for (int j = 0; j < (noOfSlots - 1); j++) {
                if (Math.random() > 0.5) {
                    // go right
                    pos += "R";
                    Rs++;
                } else pos += "L";
            }
            System.out.println(pos);
            res.set(Rs, res.get(Rs) + 1);
        }
        return res;
    }

    public static void drawResult(List<Integer> res) {
        System.out.println(res);

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.size(); j++) {
                if (res.get(j) == 0) System.out.print(" ");
                else {
                    System.out.print("O");
                    res.set(j, res.get(j) - 1);
                }
            }
            System.out.println();
        }
    }
}
