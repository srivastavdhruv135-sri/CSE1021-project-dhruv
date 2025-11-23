import random
import sys
import pyfiglet

#the welcome screen
big_text = pyfiglet.figlet_format("TIC TAC TOE")
print(big_text)

# --- Core Game Logic ---

def display_board(board):
    """
    Prints the current state of the Tic-Tac-Toe board.
    The board is a list of 10 strings, where index 0 is ignored and indices 1-9
    correspond to the numpad layout.
    """
    print('\n' * 5) # Clear the screen (visually)
    print(f'   |   |   ')
    print(f' {board[7]} | {board[8]} | {board[9]} ')
    print(f'   |   |   ')
    print('---|---|---')
    print(f'   |   |   ')
    print(f' {board[4]} | {board[5]} | {board[6]} ')
    print(f'   |   |   ')
    print('---|---|---')
    print(f'   |   |   ')
    print(f' {board[1]} | {board[2]} | {board[3]} ')
    print(f'   |   |   ')
    print()

def check_win(board, mark):
    """
    Checks if the given 'mark' ('X' or 'O') has won the game.
    Winning conditions are 3 in a row across any row, column, or diagonal.
    """
    # Check rows (1-3, 4-6, 7-9)
    return ((board[7] == mark and board[8] == mark and board[9] == mark) or
            (board[4] == mark and board[5] == mark and board[6] == mark) or
            (board[1] == mark and board[2] == mark and board[3] == mark) or
            # Check columns (1-4-7, 2-5-8, 3-6-9)
            (board[7] == mark and board[4] == mark and board[1] == mark) or
            (board[8] == mark and board[5] == mark and board[2] == mark) or
            (board[9] == mark and board[6] == mark and board[3] == mark) or
            # Check diagonals
            (board[7] == mark and board[5] == mark and board[3] == mark) or
            (board[9] == mark and board[5] == mark and board[1] == mark))

def check_space(board, position):
    """Checks if a position on the board is free (' ')."""
    return board[position] == ' '

def is_board_full(board):
    """Checks if the board is completely full (a draw)."""
    for i in range(1, 10):
        if check_space(board, i):
            return False
    return True

def player_choice(board, current_player):
    """
    Asks the current player for their move, validates the input, and returns
    the chosen position (1-9).
    """
    position = 0
    while position not in range(1, 10) or not check_space(board, position):
        try:
            choice = input(f'{current_player}, choose your next position (1-9): ')
            position = int(choice)
            if position not in range(1, 10):
                 print('This is not a valid number (must be 1-9)! Please try again.')
            elif not check_space(board, position):
                print('That position is already taken! Please try again.')
            else:
                return position
        except ValueError:
            print('Invalid input. Please enter a number between 1 and 9.')
        except Exception as e:
            print(f"An unexpected error occurred: {e}")
            sys.exit()

def place_mark(board, mark, position):
    """Places the player's mark on the board at the given position."""
    board[position] = mark

def replay():
    """Asks the player if they want to play again."""
    choice = input('Do you want to play again? Enter Yes or No: ').lower().startswith('y')
    return choice

# --- Main Game Loop ---

def start_game():
    """Initializes and runs the main Tic-Tac-Toe game."""
    print("Welcome to Tic-Tac-Toe!")
    print("The positions correspond to the number pad layout (1-9).")

    while True:
        # Reset the board
        the_board = [' '] * 10
        player1_mark = 'X'
        player2_mark = 'O'
        turn = 'Player 1'
        game_on = True

        # Game Setup
        # Optionally, you could add logic here to let players choose X or O.

        while game_on:
            if turn == 'Player 1':
                # Player 1's Turn
                display_board(the_board)
                print(f"{turn}'s turn (Mark: {player1_mark})")
                position = player_choice(the_board, turn)
                place_mark(the_board, player1_mark, position)

                if check_win(the_board, player1_mark):
                    display_board(the_board)
                    print('Player 1 has won!')
                    game_on = False
                elif is_board_full(the_board):
                    display_board(the_board)
                    print('The game is a draw!')
                    game_on = False
                else:
                    turn = 'Player 2'

            else:
                # Player 2's Turn
                display_board(the_board)
                print(f"{turn}'s turn (Mark: {player2_mark})")
                position = player_choice(the_board, turn)
                place_mark(the_board, player2_mark, position)

                if check_win(the_board, player2_mark):
                    display_board(the_board)
                    print('Player 2 has won!')
                    game_on = False
                elif is_board_full(the_board):
                    display_board(the_board)
                    print('The game is a draw!')
                    game_on = False
                else:
                    turn = 'Player 1'

        if not replay():
            print("Thanks for playing! Goodbye.")
            break

# Execute the game
if __name__ == '__main__':
    start_game()