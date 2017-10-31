package com.injusticeleague.main;

import com.injusticeleague.characters.Character;
import com.injusticeleague.common.Bonus;
import com.injusticeleague.maps.Map;
import com.injusticeleague.maps.MapFactory;
import com.injusticeleague.utils.Constants;
import com.injusticeleague.utils.FileIO;
import com.injusticeleague.utils.ScannerWrapper;

import java.util.Scanner;

public class Gameplay {

	private ScannerWrapper wrapper;

	Gameplay(ScannerWrapper wrapper) {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		this.wrapper = wrapper;
	}

	void playGame(Character character) {
		while (true) {
			if (!hasHealthSufficient(character)) {
				return;
			}

			System.out.println(Constants.LINE_BREAK);
			System.out.println(character.getName() + " has " + character.getStrengthPoints() + " health.");
			System.out.println(Constants.LINE_BREAK);
			System.out.println(Constants.GAMEPLAY_CHOOSE);

			String input = wrapper.getStringInput();

			switch (input) {
			case "1":
				exploreMaps(character);
				break;
			case "2":
				Fight fight = new Fight(wrapper);
				fight.startFight(character);
				break;
			case "3":
				FileIO fileIO = new FileIO();
				fileIO.writeToFile(character, Constants.FILE_NAME);
				System.out.println(Constants.GAME_SAVED);
				break;
			case "4":
				return;
			default:
				System.out.println(Constants.INVALID_INPUT);
				break;
			}
		}
	}

	public boolean hasHealthSufficient(Character character) {
		if (character.getStrengthPoints() < 1) {
			System.out.println("Sorry! " + character.getName() + " has no health. Please start again!");
			return false;
		}
		return true;
	}

	private void exploreMaps(Character character) {
		System.out.println(Constants.MAP_INFO);
		System.out.println(Constants.LINE_BREAK);

		MapFactory factory = new MapFactory();
		while (true) {
			if (!hasHealthSufficient(character)) {
				return;
			}

			System.out.println(Constants.CHOOSE_MAP);

			String input = wrapper.getStringInput();

			switch (input) {
			case "1":
				character.updateStrengthPoints(calculateBonus(factory, "mountain"));
				break;
			case "2":
				character.updateStrengthPoints(calculateBonus(factory, "desert"));
				break;
			case "3":
				character.updateStrengthPoints(calculateBonus(factory, "sea"));
				break;
			case "4":
				character.updateStrengthPoints(calculateBonus(factory, "city"));
				break;
			case "5":
				return;
			default:
				System.out.println(Constants.INVALID_INPUT);
				break;
			}
		}
	}

	private int calculateBonus(MapFactory factory, String code) {
		Map map = factory.getMap(code);
		int bonusCount = map.getNumberOfBonus();
		if (bonusCount == 0) {
			System.out.println(Constants.NO_BONUS);
			return 0;
		}
		System.out.println("You have received " + bonusCount + " bonuses. Congratulations... or not!");
		int bonusPoints = 0;

		while (bonusCount > 0) {
			System.out.println(Constants.BONUS);
			System.out.println(Constants.BONUS_REMAINING + bonusCount);
			String input = wrapper.getStringInput();
			switch (input) {
			case "1":
				Bonus bonus = map.getBonus();
				System.out.println(
						"Received Bonus is " + bonus.getName() + " with strength " + "points: " + bonus.getPoints());
				bonusPoints += bonus.getPoints();
				bonusCount--;
				break;
			default:
				return 0;
			}
		}

		return bonusPoints;
	}
}
