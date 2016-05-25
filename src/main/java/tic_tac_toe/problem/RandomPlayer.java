package tic_tac_toe.problem;

import tic_tac_toe.problem.Board.BoardPiece;

public class RandomPlayer extends Player {

	int[] availableRows = new int[3];
	int[] availableColumns = new int[3];

	public RandomPlayer(final String string, final boolean b) {
		super(string, b);
	}

	@Override
	public void nextMove(final String[][] board) {
		this.findAvailableBlocksInBoard(board);
		int row, col = 0;
		do {
			row = this.availableRows[(int) (System.currentTimeMillis() % this.availableRows.length)];
			col = this.availableColumns[(int) (System.currentTimeMillis() % this.availableColumns.length)];
		} while (!board[row][col].equals(BoardPiece.EMPTY));

		board[row][col] = this.getPlaceholder();
		return;
	}

	private void findAvailableBlocksInBoard(final String[][] board) {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (board[i][j].equals(BoardPiece.EMPTY)) {
					this.availableRows[i] = i;
					this.availableColumns[j] = j;
				}
			}

		}

	}

}
