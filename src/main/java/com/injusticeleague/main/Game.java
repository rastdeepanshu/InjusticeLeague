package com.injusticeleague.main;

import com.injusticeleague.characters.Character;
import com.injusticeleague.characters.Gender;
import com.injusticeleague.utils.Constants;
import com.injusticeleague.utils.FileIO;
import com.injusticeleague.utils.ScannerWrapper;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Game {

	private ScannerWrapper wrapper;

	Game(ScannerWrapper wrapper) {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		this.wrapper = wrapper;
	}

	void resumeGame() {
		FileIO fileIO = new FileIO();
		Character character = fileIO.readFromFile(Constants.FILE_NAME);
		if(character == null) {
			System.out.println(Constants.NO_SAVE);
			return;
		}
		Gameplay gameplay = new Gameplay(wrapper);
		gameplay.playGame(character);
	}

	void startGame() {
		Character character = null;
		while (true) {
			System.out.println(Constants.CHOOSE_GAME_START);

			String input = wrapper.getStringInput();

			switch (input) {
			case "1":
				if (character != null) {
					System.out.println("Character already created.\n");
				} else {
					character = createCharacter();
				}
				break;
			case "2":
				if (character == null) {
					System.out.println("Create a character first.");
				} else {
					Gameplay gameplay = new Gameplay(wrapper);
					gameplay.playGame(character);
				}
				break;
			case "3":
				return;
			default:
				System.out.println(Constants.INVALID_INPUT);
				break;
			}
		}
	}

	private Character createCharacter() {
		Character character = new Character();

		System.out.println(Constants.CHAR_NAME);
		character.setName(wrapper.getStringInput());

		System.out.println(Constants.CHAR_DESC);
		character.setDescription(wrapper.getStringInput());

		character.setGender(getGender());

		choosePowers(character);

		System.out.println("#### " + character.getName() + " created! ####");

		return character;
	}

	public Gender getGender() {
		while (true) {
			System.out.println(Constants.CHOOSE_GENDER);

			String input = wrapper.getStringInput();

			switch (input) {
			case "1":
				return Gender.Male;
			case "2":
				return Gender.Female;
			default:
				System.out.println(Constants.INVALID_INPUT);
				break;
			}
		}
	}

	public void choosePowers(Character character) {
		System.out.println(Constants.POWERS_RULES);
		System.out.println(Constants.CHOOSE_POWERS);

		int limit = 5;
		Set<String> powerSet = new HashSet<>();
		while (limit > 0) {
			String input = wrapper.getStringInput();
			if (powerSet.contains(input)) {
				System.out.println(Constants.POWER_PRESENT);
				continue;
			}
			switch (input) {
			case "1":
				powerSet.add(input);
				character.setFly(true);
				limit--;
				break;
			case "2":
				powerSet.add(input);
				character.setBreathInWater(true);
				limit--;
				break;
			case "3":
				powerSet.add(input);
				character.setDodgeBullets(true);
				limit--;
				break;
			case "4":
				powerSet.add(input);
				character.setRich(true);
				limit--;
				break;
			case "5":
				powerSet.add(input);
				character.setRunFast(true);
				limit--;
				break;
			case "6":
				powerSet.add(input);
				character.setChangeWeather(true);
				limit--;
				break;
			case "7":
				powerSet.add(input);
				character.setLaserEyes(true);
				limit--;
				break;
			default:
				System.out.println(Constants.INVALID_INPUT);
				break;
			}
		}
	}
}
