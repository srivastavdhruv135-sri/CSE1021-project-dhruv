import java.util.Scanner;

public class TicTacToe {

    static Scanner scanner = new Scanner(System.in);

    // Display the board
    public static void displayBoard(char[] board) {
        System.out.println("\n\n\n");

        System.out.println("   |   |   ");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9]);
        System.out.println("   |   |   ");
        System.out.println("---|---|---");
        System.out.println("   |   |   ");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("   |   |   ");
        System.out.println("---|---|---");
        System.out.println("   |   |   ");
        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("   |   |   ");

        System.out.println();
    }

    // Check whether a player has won
    public static boolean checkWin(char[] board, char mark) {

        return
            // Rows
            (board[7] == mark && board[8] == mark && board[9] == mark) ||
            (board[4] == mark && board[5] == mark && board[6] == mark) ||
            (board[1] == mark && board[2] == mark && board[3] == mark) ||

            // Columns
            (board[7] == mark && board[4] == mark && board[1] == mark) ||
            (board[8] == mark && board[5] == mark && board[2] == mark) ||
            (board[9] == mark && board[6] == mark && board[3] == mark) ||

            // Diagonals
            (board[7] == mark && board[5] == mark && board[3] == mark) ||
            (board[9] == mark && board[5] == mark && board[1] == mark);
    }

    // Check whether a position is empty
    public static boolean checkSpace(char[] board, int position) {
        return board[position] == ' ';
    }

    // Check whether board is full
    public static boolean isBoardFull(char[] board) {

        for (int i = 1; i <= 9; i++) {
            if (checkSpace(board, i)) {
                return false;
            }
        }

        return true;
    }

    // Get player's move
    public static int playerChoice(char[] board, String currentPlayer) {

        while (true) {

            System.out.print(
                currentPlayer + ", choose your next position (1-9): "
            );

            String input = scanner.nextLine();

            try {
                int position = Integer.parseInt(input);

                if (position < 1 || position > 9) {
                    System.out.println(
                        "This is not a valid number! Please enter 1-9."
                    );
                }
                else if (!checkSpace(board, position)) {
                    System.out.println(
                        "That position is already taken!"
                    );
                }
                else {
                    return position;
                }

            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid input. Please enter a number between 1 and 9."
                );
            }
        }
    }

    // Place player's mark
    public static void placeMark(char[] board, char mark, int position) {
        board[position] = mark;
    }

    // Ask whether player wants to play again
    public static boolean replay() {

        System.out.print(
            "Do you want to play again? Enter Yes or No: "
        );

        String choice = scanner.nextLine();

        return choice.toLowerCase().startsWith("y");
    }

    // Start game
    public static void startGame() {

        System.out.println("=================================");
        System.out.println("        TIC TAC TOE");
        System.out.println("=================================");

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println(
            "Positions correspond to the number pad layout (1-9)."
        );

        while (true) {

            // Create new board
            char[] board = new char[10];

            for (int i = 1; i <= 9; i++) {
                board[i] = ' ';
            }

            char player1Mark = 'X';
            char player2Mark = 'O';

            String turn = "Player 1";
            boolean gameOn = true;

            // Main game loop
            while (gameOn) {

                displayBoard(board);

                if (turn.equals("Player 1")) {

                    System.out.println(
                        turn + "'s turn (Mark: " + player1Mark + ")"
                    );

                    int position = playerChoice(board, turn);

                    placeMark(board, player1Mark, position);

                    if (checkWin(board, player1Mark)) {

                        displayBoard(board);
                        System.out.println("Player 1 has won!");
                        gameOn = false;

                    }
                    else if (isBoardFull(board)) {

                        displayBoard(board);
                        System.out.println("The game is a draw!");
                        gameOn = false;

                    }
                    else {
                        turn = "Player 2";
                    }

                }
                else {

                    System.out.println(
                        turn + "'s turn (Mark: " + player2Mark + ")"
                    );

                    int position = playerChoice(board, turn);

                    placeMark(board, player2Mark, position);

                    if (checkWin(board, player2Mark)) {

                        displayBoard(board);
                        System.out.println("Player 2 has won!");
                        gameOn = false;

                    }
                    else if (isBoardFull(board)) {

                        displayBoard(board);
                        System.out.println("The game is a draw!");
                        gameOn = false;

                    }
                    else {
                        turn = "Player 1";
                    }
                }
            }

            // Replay
            if (!replay()) {

                System.out.println(
                    "Thanks for playing! Goodbye."
                );

                break;
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        startGame();
    }
}