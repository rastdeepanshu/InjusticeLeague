package com.injusticeleague.common;

/**
 * Bonuses provided in the game.
 */
public enum Bonus {
	Kryptonite(5, "Kryptonite"), Gun(2, "Gun"), Alcohol(-2, "Alcohol"), Television(-5, "Television"), Fat(-2,
			"Fat"), Drugs(-10, "Drugs"), Boredom(-1, "Boredom"), Herbs(3, "Herbs");

	private int points;
	private String name;

	private Bonus(int points, String name) {
		this.points = points;
		this.name = name;
	}

	public int getPoints() {
		return this.points;
	}

	public String getName() {
		return this.name;
	}
}
