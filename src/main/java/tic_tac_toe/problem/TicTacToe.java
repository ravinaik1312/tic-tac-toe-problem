package tic_tac_toe.problem;

import java.util.Scanner;

public class TicTacToe {

	public void initializeGame() {
		final int option = this.promptPreGameInputs();
		final Board board = new Board();
		board.initialize(board, option);
	}

	private int promptPreGameInputs() {
		System.out.println("What mode of game do you want? ");
		System.out.println("1. Human vs Human");
		System.out.println("2. Human vs Computer");
		System.out.println("3. Computer vs Computer");
		final Scanner in = new Scanner(System.in);
		final int option = in.nextInt();
		return option;
	}
}
