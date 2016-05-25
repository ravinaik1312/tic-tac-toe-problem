package tic_tac_toe.problem;

public class Board {

	interface BoardPiece {
		final String X = "X";
		final String O = "O";
		final String EMPTY = " ";
	}

	interface CurrentPlayer {
		final String X = "X";
		final String O = "O";
	}

	private String board[][];

	public void initialize(final Board board, final int option) {
		switch (option) {
			case 1:
				board.startGame(new HumanPlayer("X", true), new HumanPlayer("O", true));
				break;
			case 2:
				board.startGame(new HumanPlayer("X", true), new RandomPlayer("O", false));
				break;
			case 3:
				board.startGame(new RandomPlayer("X", false), new RandomPlayer("O", false));
				break;
			default:
				System.out.println("Invalid Option. ");
				break;
		}
	}

	private void startGame(final Player player1, final Player player2) {
		System.out.println("Starting game between...");
		System.out.println("Player 1 playing with " + player1.getPlaceholder() + " and Player 2 playing with " + player2.getPlaceholder());
		this.initializeEmptyBoard(this.board);
		this.playGame(player1, player2);
		System.out.println("Game Over!!!");
	}

	private void playGame(final Player player1, final Player player2) {

		String currentPlayer = CurrentPlayer.X;
		while (!this.isBoardFull()) {
			if (currentPlayer.equals(CurrentPlayer.X)) {
				player1.nextMove(this.board);
				this.printBoard();
				if (this.hasWon()) {
					System.out.println("Player " + player1.getPlaceholder() + " " + player1.getName() + " has won!!!!!");
					return;
				}
				else {
					currentPlayer = CurrentPlayer.O;
				}

			}
			else
			{
				player2.nextMove(this.board);
				this.printBoard();
				if (this.hasWon()) {
					System.out.println("Player " + player2.getPlaceholder() + " " + player2.getName() + " has won!!!!!");
					return;
				}
				else {
					currentPlayer = CurrentPlayer.X;
				}
			}
		}
		System.out.println("GAME ENDED IN A DRAW");
	}

	private boolean isBoardFull() {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (this.board[i][j].equals(BoardPiece.EMPTY)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean hasWon() {

		for (int i = 0; i < this.board.length; ++i) {
			// all values in a row
			if (this.checkWinner(this.board[i][0], this.board[i][1], this.board[i][2])) {
				// System.out.println("Player with " + this.board[i][0] + " has won!!!");
				return true;
			}

			// all values in a column
			if (this.checkWinner(this.board[0][i], this.board[1][i], this.board[2][i])) {
				// System.out.println("Player with " + this.board[0][i] + " has won!!!");
				return true;
			}
		}

		// diagonal
		if (this.checkWinner(this.board[0][0], this.board[1][1], this.board[2][2])) {
			// System.out.println("Player with " + this.board[0][0] + " has won!!!");
			return true;
		}

		// other diagonal
		if (this.checkWinner(this.board[0][2], this.board[1][1], this.board[2][0])) {
			// System.out.println("Player with " + this.board[2][0] + " has won!!!");
			return true;
		}
		return false;
	}

	private boolean checkWinner(final String string1, final String string2, final String string3) {
		if (string1.equals(BoardPiece.EMPTY)) {
			return false;
		} else {
			return (string1.equals(string2) && string2.equals(string3));
		}
	}

	private void initializeEmptyBoard(final String[][] board2) {
		// TODO: Generalize it for nxn board
		this.board = new String[3][3];
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				this.board[i][j] = BoardPiece.EMPTY;
			}
		}
		this.printBoard();
	}

	public void printBoard() {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				printBlock(this.board[i][j]);
				if (j != 2) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (i != 2) {
				System.out.println("--- --- ---");
			}
		}
		System.out.println();
	}

	public static void printBlock(final String content) {
		switch (content) {
			case BoardPiece.EMPTY:
				System.out.print("  ");
				break;
			case BoardPiece.X:
				System.out.print(" X ");
				break;
			case BoardPiece.O:
				System.out.print(" O ");
				break;
		}
	}

}