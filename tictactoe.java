import java.util.Scanner;

public class tictactoe {

    static char[][] b = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        char p = 'X';
        int m = 0;

        while (true) {

            show();

            System.out.println("Player " + p + " turn");

            System.out.print("Enter row (1-3): ");
            int r = sc.nextInt() - 1;

            System.out.print("Enter col (1-3): ");
            int c = sc.nextInt() - 1;

            if (r < 0 || r > 2 || c < 0 || c > 2) {
                System.out.println("Invalid position. Try again.");
                continue;
            }

            if (b[r][c] != ' ') {
                System.out.println("Cell already taken. Try again.");
                continue;
            }

            b[r][c] = p;
            m++;

            if (win(p)) {
                show();
                System.out.println("Player " + p + " wins!");
                break;
            }

            if (m == 9) {
                show();
                System.out.println("Game Draw!");
                break;
            }

            if (p == 'X')
                p = 'O';
            else
                p = 'X';
        }
    }

    static void show() {

        System.out.println();

        for (int i = 0; i < 3; i++) {

            System.out.println(" " + b[i][0] + " | " + b[i][1] + " | " + b[i][2]);

            if (i < 2)
                System.out.println("---+---+---");
        }

        System.out.println();
    }

    static boolean win(char p) {

        for (int i = 0; i < 3; i++) {

            if (b[i][0] == p && b[i][1] == p && b[i][2] == p)
                return true;

            if (b[0][i] == p && b[1][i] == p && b[2][i] == p)
                return true;
        }

        if (b[0][0] == p && b[1][1] == p && b[2][2] == p)
            return true;

        if (b[0][2] == p && b[1][1] == p && b[2][0] == p)
            return true;

        return false;
    }
}