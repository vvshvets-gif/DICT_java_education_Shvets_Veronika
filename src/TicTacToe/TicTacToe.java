package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String input = scanner.next();
        printGrid(input.toCharArray());


    }

    public static void printGrid(char[] cells) {
        System.out.println("---------");
        System.out.println("| " + cells[0] + " " + cells[1] + " " + cells[2] + " |");
        System.out.println("| " + cells[3] + " " + cells[4] + " " + cells[5] + " |");
        System.out.println("| " + cells[6] + " " + cells[7] + " " + cells[8] + " |");
        System.out.println("---------");
    }

    public static String checkState(char[] cells) {
        int xCount = 0, oCount = 0, empty = 0;
        for (char c : cells) {
            if (c == 'X') xCount++;
            else if (c == 'O') oCount++;
            else empty++;
        }

        boolean xWins = checkWin(cells, 'X');
        boolean oWins = checkWin(cells, 'O');

        if (Math.abs(xCount - oCount) >= 2 || (xWins && oWins)) return "Impossible";
        if (xWins) return "X wins";
        if (oWins) return "O wins";
        if (empty == 0) return "Draw";
        return "Game not finished";
    }

    private static boolean checkWin(char[] c, char p) {
        return (c[0] == p && c[1] == p && c[2] == p) || (c[3] == p && c[4] == p && c[5] == p) ||
                (c[6] == p && c[7] == p && c[8] == p) || (c[0] == p && c[3] == p && c[6] == p) ||
                (c[1] == p && c[4] == p && c[7] == p) || (c[2] == p && c[5] == p && c[8] == p) ||
                (c[0] == p && c[4] == p && c[8] == p) || (c[2] == p && c[4] == p && c[6] == p);
    }
}
