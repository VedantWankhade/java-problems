package general.recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        System.out.print("Enter number of disks: ");
        Scanner sc = new Scanner(System.in);
        int n = Math.abs(sc.nextInt());

        System.out.println("The moves are: ");
        moveDisks(n, 'A', 'B', 'C');
    }

    public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
        if (n == 1) System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        else {
            System.out.println("Move disk " + n + " from " + fromTower + " to " + auxTower);
            moveDisks(n - 1, fromTower, auxTower, toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }
}
