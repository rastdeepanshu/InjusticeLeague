package com.injusticeleague.characters;

import java.io.Serializable;

public class Character implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 732048740374374860L;
	
	private String name;
	private String description;
	private Gender gender;
	private boolean fly = false;
	private boolean breathInWater = false;
	private boolean dodgeBullets = false;
	private boolean isRich = false;
	private boolean runFast = false;
	private boolean changeWeather = false;
	private boolean laserEyes = false;
	private int strengthPoints = 50;
	private int experience;
	private int currentLevel = 7;

	public Character() {
	}

	public Character(String name, String description, Gender gender, boolean fly, boolean breathInWater,
			boolean dodgeBullets, boolean isRich, boolean runFast, boolean canChangeWeather, boolean hasLaserEyes) {
		this.name = name;
		this.description = description;
		this.gender = gender;
		this.fly = fly;
		this.breathInWater = breathInWater;
		this.dodgeBullets = dodgeBullets;
		this.isRich = isRich;
		this.runFast = runFast;
		this.changeWeather = canChangeWeather;
		this.laserEyes = hasLaserEyes;
	}

	public String getDescription() {
		return description;
	}

	public Gender getGender() {
		return gender;
	}

	public boolean canFly() {
		return fly;
	}

	public boolean canBreathInWater() {
		return breathInWater;
	}

	public boolean canDodgeBullets() {
		return dodgeBullets;
	}

	public boolean isRich() {
		return isRich;
	}

	public boolean canRunFast() {
		return runFast;
	}

	public boolean canChangeWeather() {
		return changeWeather;
	}

	public boolean hasLaserEyes() {
		return laserEyes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setFly(boolean fly) {
		if (fly) {
			strengthPoints += Strength.Fly.getStrengthPoints();
		}
		this.fly = fly;
	}

	public void setBreathInWater(boolean breathInWater) {
		if (breathInWater) {
			strengthPoints += Strength.BreatheInWater.getStrengthPoints();
		}
		this.breathInWater = breathInWater;
	}

	public void setDodgeBullets(boolean dodgeBullets) {
		if (dodgeBullets) {
			strengthPoints += Strength.DodgeBullets.getStrengthPoints();
		}
		this.dodgeBullets = dodgeBullets;
	}

	public void setRich(boolean rich) {
		if (rich) {
			strengthPoints += Strength.Rich.getStrengthPoints();
		}
		isRich = rich;
	}

	public void setRunFast(boolean runFast) {
		if (runFast) {
			strengthPoints += Strength.RunFast.getStrengthPoints();
		}
		this.runFast = runFast;
	}

	public void setChangeWeather(boolean changeWeather) {
		if (changeWeather) {
			strengthPoints += Strength.ChangeWeather.getStrengthPoints();
		}
		this.changeWeather = changeWeather;
	}

	public void setLaserEyes(boolean laserEyes) {
		if (laserEyes) {
			strengthPoints += Strength.LaserEyes.getStrengthPoints();
		}
		this.laserEyes = laserEyes;
	}

	public int getStrengthPoints() {
		return strengthPoints;
	}

	public void updateStrengthPoints(int points) {
		this.strengthPoints += points;
	}

	public int getExperience() {
		return experience;
	}

	public void incrementExperience() {
		experience++;
		strengthPoints += experience * 5;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void incrementLevel() {
		this.currentLevel--;
	}

	@Override
	public String toString() {
		return "Character{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", gender=" + gender
				+ ", fly=" + fly + ", breathInWater=" + breathInWater + ", dodgeBullets=" + dodgeBullets + ", isRich="
				+ isRich + ", runFast=" + runFast + ", changeWeather=" + changeWeather + ", laserEyes=" + laserEyes
				+ ", strengthPoints=" + strengthPoints + ", experience=" + experience + ", currentLevel=" + currentLevel
				+ '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Character character = (Character) o;

		if (fly != character.fly) return false;
		if (breathInWater != character.breathInWater) return false;
		if (dodgeBullets != character.dodgeBullets) return false;
		if (isRich != character.isRich) return false;
		if (runFast != character.runFast) return false;
		if (changeWeather != character.changeWeather) return false;
		if (laserEyes != character.laserEyes) return false;
		if (strengthPoints != character.strengthPoints) return false;
		if (experience != character.experience) return false;
		if (currentLevel != character.currentLevel) return false;
		if (name != null ? !name.equals(character.name) : character.name != null) return false;
		if (description != null ? !description.equals(character.description) : character.description != null)
			return false;
		return gender == character.gender;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (gender != null ? gender.hashCode() : 0);
		result = 31 * result + (fly ? 1 : 0);
		result = 31 * result + (breathInWater ? 1 : 0);
		result = 31 * result + (dodgeBullets ? 1 : 0);
		result = 31 * result + (isRich ? 1 : 0);
		result = 31 * result + (runFast ? 1 : 0);
		result = 31 * result + (changeWeather ? 1 : 0);
		result = 31 * result + (laserEyes ? 1 : 0);
		result = 31 * result + strengthPoints;
		result = 31 * result + experience;
		result = 31 * result + currentLevel;
		return result;
	}
}
