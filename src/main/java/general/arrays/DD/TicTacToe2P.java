package general.arrays.DD;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe2P {

    static Character[][] board = new Character[3][3];

    static {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                board[i][j] = ' ';
    }

    public static void play() {
        printBoard();
        boolean flag = false;
        int i = 0;
        while (i < 9) {
            System.out.print("Enter a row for player " + (flag ? "X" : "Y") + " : ");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            System.out.print("Enter a column for player " + (flag ? "X" : "Y") + " : ");
            int y = sc.nextInt();
            if (setUser(flag = !flag, x, y)) {
                i++;
            } else {
                System.out.println("OCCUPIED... TRY AGAIN");
                continue;
            }
            printBoard();

            if (i > 4 && checkWin(flag, x, y)) {
                System.out.println((flag ? "X" : "Y") + " WINS!!!");
                break;
            }
        }
    }

    public static boolean checkWin(boolean flag, int x, int y) {
            char user = flag ? 'X' : 'Y';

            if ((x == y && ((board[0][0] == user && board[1][1] == user && board[2][2] == user) || (board[0][2] == user && board[1][1] == user && board[2][0] == user)))
                    || (board[x + 1][y] == user && board[x + 2][y] == user)
                    || (board[x][y + 1] == user && board[x][y + 2] == user)
                    /*|| (if ())*/
            ) return true;
return true;
    }

    public static boolean setUser(boolean flag, int x, int y) {
        System.out.println((flag ? "X" : "Y") + " -> [" + x + ", " + y + "]");

        if (board[x][y] != ' ')
            return false;

        board[x][y] = flag ? 'X' : 'Y';
        return true;

    }

    private static void printBoard() {
        System.out.println("\n  _   _   _ ");

        Arrays.stream(board).forEach((row -> {

            System.out.print("| ");
            Arrays.stream(row).forEach(c -> {
                System.out.print( c + " | ");
            });
            System.out.println("\n  _   _   _ ");
        }));
    }

    public static void main(String[] args) {
        play();
    }
}
