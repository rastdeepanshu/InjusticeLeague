package com.injusticeleague.characters;

/**
 * The Enemies present in the game.
 */
public enum Enemy {

	Superman(250, "Superman", 50), Batman(210, "Batman", 50), WonderWoman(200, "Wonder Woman", 40), Flash(190,
			"Flash", 30), Aquaman(170, "Aquaman", 25), Cyborg(160, "Cyborg", 15);

	private int strengthPoints;
	private String name;
	private int difficultyLevel;

	Enemy(int points, String name, int difficultyLevel) {
		this.strengthPoints = points;
		this.name = name;
		this.difficultyLevel = difficultyLevel;
	}

	public int getStrengthPoints() {
		return this.strengthPoints;
	}

	public String getName() {
		return this.name;
	}
	
	public int getDifficultyLevel() {
		return this.difficultyLevel;
	}
}
