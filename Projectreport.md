# Project Report: Java Tic-Tac-Toe

## 1. Project Overview

### Project Title

Console-Based Tic-Tac-Toe Game Using Java

### Objective

The project implements a complete two-player Tic-Tac-Toe game for the command line. It demonstrates how Java classes, methods, arrays, loops, conditionals, and exception handling can be combined to build an interactive application.

## 2. Technologies Used

| Component | Technology | Purpose |
| --- | --- | --- |
| Programming language | Java 8+ | Application logic |
| Input handling | `java.util.Scanner` | Reads player choices |
| Data structure | `char[]` | Stores the nine board positions |
| Error handling | `NumberFormatException` | Handles invalid numeric input |
| Output | `System.out` | Displays the board and results |

No third-party libraries are required.

## 3. Game Design

The board uses an array with indexes 1 through 9. Index 0 is unused so that the array indexes match the positions shown to players.

```text
 7 | 8 | 9
---+---+---
 4 | 5 | 6
---+---+---
 1 | 2 | 3
```

Each round starts with an empty board. Player 1 uses `X`, Player 2 uses `O`, and turns alternate after every valid move.

## 4. Program Workflow

1. `main()` starts the application.
2. `startGame()` prints the title and controls replaying.
3. `playRound()` creates a new board and manages the turn loop.
4. `displayBoard()` prints the current board.
5. `getPlayerChoice()` repeatedly requests input until the move is valid.
6. The selected mark is placed on the board.
7. `hasWon()` checks all rows, columns, and diagonals.
8. `isBoardFull()` identifies a draw when no positions remain.
9. `askToReplay()` starts another round when the player enters a response beginning with `Y`.

## 5. Java Concepts Demonstrated

- `public class Main` as the application entry point
- A `static final Scanner` shared by input methods
- Private methods that separate display, input, validation, and game logic
- A two-dimensional array of winning combinations
- `for` loops and enhanced `for` loops
- `try-catch` handling for invalid input
- Boolean methods for reusable game-state checks

## 6. Testing

The project can be compiled and executed with:

```bash
javac Main.java
java Main
```

Manual test cases include:

| Test case | Expected result |
| --- | --- |
| Enter a position outside 1-9 | The program asks again |
| Enter letters instead of a number | The program reports invalid input |
| Select an occupied position | The program asks for another position |
| Complete three marks in a line | The correct player wins |
| Fill every position without a winner | The game reports a draw |
| Enter `Yes` after a round | A fresh board is created |

## 7. Conclusion

This project is a small but complete Java console application. Its separated helper methods make the code easy to read, test, and extend with features such as a computer opponent, score tracking, or a graphical user interface.
