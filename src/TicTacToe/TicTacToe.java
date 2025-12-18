package TicTacToe;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] cells = "_________".toCharArray();
        printGrid(cells);

        char currentPlayer = 'X';
        while (true) {
            System.out.print("Enter the coordinates: ");
            String inputX = scanner.next();
            String inputY = scanner.next();

            if (!isNumber(inputX) || !isNumber(inputY)) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int row = Integer.parseInt(inputX);
            int col = Integer.parseInt(inputY);

            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            int index = (row - 1) * 3 + (col - 1);
            if (cells[index] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            cells[index] = currentPlayer;
            printGrid(cells);

            String state = checkState(cells);
            if (!state.equals("Game not finished")) {
                System.out.println(state);
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private static boolean isNumber(String s) {
        return s.matches("\\d+");
    }

    public static void printGrid(char[] cells) {
        System.out.println("---------");
        System.out.println("| " + cells[0] + " " + cells[1] + " " + cells[2] + " |");
        System.out.println("| " + cells[3] + " " + cells[4] + " " + cells[5] + " |");
        System.out.println("| " + cells[6] + " " + cells[7] + " " + cells[8] + " |");
        System.out.println("---------");
    }

    public static String checkState(char[] cells) {
        boolean xWins = checkWin(cells, 'X');
        boolean oWins = checkWin(cells, 'O');
        int empty = 0;
        for (char c : cells) if (c == '_') empty++;

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