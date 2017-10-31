package com.injusticeleague.characters;

/**
 * The Strengths of the character
 */
public enum Strength {

	Fly(30), BreatheInWater(15), DodgeBullets(10), Rich(5), RunFast(20), ChangeWeather(20), LaserEyes(10);

	private int strengthPoints;

	Strength(int points) {
		this.strengthPoints = points;
	}

	public int getStrengthPoints() {
		return this.strengthPoints;
	}
}
