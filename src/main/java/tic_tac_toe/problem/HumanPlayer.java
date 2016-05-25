package tic_tac_toe.problem;

import java.util.Scanner;

import tic_tac_toe.problem.Board.BoardPiece;

public class HumanPlayer extends Player {

	public HumanPlayer(final String string, final boolean b) {
		super(string, b);
	}

	@Override
	public void nextMove(final String[][] board) {
		final Scanner in = new Scanner(System.in);
		boolean isValid = false;
		do {
			System.out.println("Player " + this.getPlaceholder()
					+ " make your move by entering the location for you placeholder");
			System.out.print("Enter row number: ");
			final int row = in.nextInt() - 1;
			System.out.print("Enter column number: ");
			final int col = in.nextInt() - 1;
			if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == BoardPiece.EMPTY) {
				board[row][col] = this.getPlaceholder();
				isValid = true;
				return;
			} else {
				System.out.println("Invalid Move, try again...");
			}
		} while (!isValid);
	}
}
