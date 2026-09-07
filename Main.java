import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        printTitle();
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("The positions correspond to the number pad layout (1-9).");

        boolean playAgain = true;
        while (playAgain) {
            playRound();
            playAgain = askToReplay();
        }

        System.out.println("Thanks for playing! Goodbye.");
    }

    private static void playRound() {
        char[] board = new char[10];
        for (int position = 1; position <= 9; position++) {
            board[position] = ' ';
        }

        int currentPlayer = 1;
        boolean gameOn = true;

        while (gameOn) {
            displayBoard(board);
            char mark = currentPlayer == 1 ? 'X' : 'O';
            int position = getPlayerChoice(board, currentPlayer);
            board[position] = mark;

            if (hasWon(board, mark)) {
                displayBoard(board);
                System.out.println("Player " + currentPlayer + " has won!");
                gameOn = false;
            } else if (isBoardFull(board)) {
                displayBoard(board);
                System.out.println("The game is a draw!");
                gameOn = false;
            } else {
                currentPlayer = currentPlayer == 1 ? 2 : 1;
            }
        }
    }

    private static void displayBoard(char[] board) {
        System.out.println();
        System.out.println("   |   |   ");
        System.out.printf(" %c | %c | %c %n", board[7], board[8], board[9]);
        System.out.println("   |   |   ");
        System.out.println("---|---|---");
        System.out.println("   |   |   ");
        System.out.printf(" %c | %c | %c %n", board[4], board[5], board[6]);
        System.out.println("   |   |   ");
        System.out.println("---|---|---");
        System.out.println("   |   |   ");
        System.out.printf(" %c | %c | %c %n", board[1], board[2], board[3]);
        System.out.println("   |   |   ");
        System.out.println();
    }

    private static int getPlayerChoice(char[] board, int player) {
        while (true) {
            System.out.print("Player " + player + ", choose your next position (1-9): ");
            String input = SCANNER.nextLine().trim();

            try {
                int position = Integer.parseInt(input);
                if (position < 1 || position > 9) {
                    System.out.println("This is not a valid number (must be 1-9)! Please try again.");
                } else if (board[position] != ' ') {
                    System.out.println("That position is already taken! Please try again.");
                } else {
                    return position;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
            }
        }
    }

    private static boolean hasWon(char[] board, char mark) {
        int[][] winningLines = {
            {7, 8, 9}, {4, 5, 6}, {1, 2, 3},
            {7, 4, 1}, {8, 5, 2}, {9, 6, 3},
            {7, 5, 3}, {9, 5, 1}
        };

        for (int[] line : winningLines) {
            if (board[line[0]] == mark && board[line[1]] == mark && board[line[2]] == mark) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBoardFull(char[] board) {
        for (int position = 1; position <= 9; position++) {
            if (board[position] == ' ') {
                return false;
            }
        }
        return true;
    }

    private static boolean askToReplay() {
        System.out.print("Do you want to play again? Enter Yes or No: ");
        return SCANNER.nextLine().trim().toLowerCase().startsWith("y");
    }

    private static void printTitle() {
        System.out.println("================");
        System.out.println("  TIC TAC TOE");
        System.out.println("================");
    }
}