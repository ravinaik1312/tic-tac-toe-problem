package tic_tac_toe.problem;

public abstract class Player {
	private String placeholder;
	private boolean isHuman;
	private String name;

	public Player() {
	}

	public Player(final String move, final boolean isHuman) {
		super();
		this.placeholder = move;
		this.isHuman = isHuman;
		this.name = this.isHuman ? "human" : "computer";
	}

	public String getPlaceholder() {
		return this.placeholder;
	}

	public void setPlaceholder(final String move) {
		this.placeholder = move;
	}

	public boolean isHuman() {
		return this.isHuman;
	}

	public void setHuman(final boolean isHuman) {
		this.isHuman = isHuman;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public abstract void nextMove(String board[][]);

}
