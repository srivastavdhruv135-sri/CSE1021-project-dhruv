# 📄 Project Report: Tic-Tac-Toe Game

### 1. Project Overview

#### Project Title
*Console-Based Tic-Tac-Toe Game (Two-Player)*

#### Executive Summary
This project implements the classic *Tic-Tac-Toe* game as a two-player, command-line interface (CLI) application. Built with *Python, the game features an intuitive **1-9 keypad-style input system* and uses the pyfiglet library for a professional, ASCII-art welcome screen. The application ensures valid moves, automatically detects win conditions (rows, columns, diagonals), and handles draws, offering a simple and complete gaming experience.

---
### 2. Technical Specifications

#### 💻 Technologies Used
| Component | Technology/Module | Purpose |
| :--- | :--- | :--- |
| *Language* | *Python 3.x* | Core development language. |
| *Graphics* | *pyfiglet* | Generates the large ASCII art "TIC TAC TOE" title. |
| *Game Logic* | *random* | Used for generating random elements, potentially for determining the starting player. |
| *System I/O* | *sys* | Used for graceful program exit (sys.exit()) in error handling. |
| *Data Structure* | *List (10 elements)* | Represents the game board, using indices 1-9 for board positions. |

#### 🕹 Board Mapping (Key Feature)
The game uses a *numeral input system* where positions correspond directly to the keyboard's numeric keypad for highly intuitive CLI play.

| Row | Col 1 | Col 2 | Col 3 |
| :--- | :--- | :--- | :--- |
| *Top* | 7 | 8 | 9 |
| *Middle* | 4 | 5 | 6 |
| *Bottom* | 1 | 2 | 3 |

[Image of a 3x3 grid for Tic Tac Toe numbered 1-9 like a phone keypad where the bottom row is 1, 2, 3, the middle is 4, 5, 6, and the top is 7, 8, 9]

---
### 3. System Workflow

#### 🔄 Project Workflow
The game follows a clear, cyclical workflow designed to handle turns, check for termination conditions, and offer replayability.

1.  *Initialization:* The start_game() function is called. The board is reset, marks are assigned ('X' and 'O'), and the main game loop begins.
2.  *Turn Start:* The *current player* is determined.
3.  *Display Board:* The current state of the board is displayed.
4.  **Player Input (player_choice):** User is prompted for a position (1-9). Input is validated for range (1-9) and if the space is *empty*.
5.  **Place Mark (place_mark):** If valid, the player's mark is placed on the board.
6.  *Check Status:* The game checks for a *Win* (check_win()) or a *Draw* (is_board_full()).
7.  *Game End/Switch:* If Win or Draw, the game ends, results are displayed, and the user is asked to replay(). If the game continues, the turn is switched.
8.  *Replay:* If the user chooses 'Yes', the entire process loops back to Step 1 (resetting the board); otherwise, the program exits.

---
### 4. Flowchart Description

A flowchart visually maps the logic of the main game loop.

#### 📐 Main Game Flowchart Steps
| Shape | Action/Function | Description |
| :--- | :--- | :--- |
| *Start/End* | *START*