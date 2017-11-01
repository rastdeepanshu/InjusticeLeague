package com.injusticeleague.main;

import com.injusticeleague.characters.Character;
import com.injusticeleague.characters.Enemy;
import com.injusticeleague.common.EnemiesUtil;
import com.injusticeleague.utils.Constants;
import com.injusticeleague.utils.ImageDrawer;
import com.injusticeleague.utils.ScannerWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Fight {

	private ScannerWrapper wrapper;

	private List<String> operators = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6819109966964412053L;

		{
			add("+");
			add("*");
			add("-");
			add("*");
		}
	};

	Fight(ScannerWrapper wrapper) {
		this.wrapper = wrapper;
	}

	void startFight(Character character) {
		if(character.getCurrentLevel() == 1){
			System.out.println(Constants.WORLD_SAVED);
			ImageDrawer drawer = new ImageDrawer();
			drawer.printAsciiImage("OUR HERO");
			return;
		}
		EnemiesUtil enemiesUtil = new EnemiesUtil();
		Enemy enemy = enemiesUtil.getNextEnemy(character.getCurrentLevel());
		int enemyStrength = enemy.getStrengthPoints();
		System.out.println("Your next opponent is: " + enemy.getName());

		System.out.println(Constants.FIGHT_RULES);

		ImageDrawer drawer = new ImageDrawer();
		drawer.printAsciiImage(enemy.getName());

		while (character.getStrengthPoints() > 0 && enemyStrength > 0) {
			System.out.println(Constants.LINE_BREAK);
			System.out.println("Your strength: " + character.getStrengthPoints());
			System.out.println("Opponent's strength: " + enemyStrength);
			System.out.println(Constants.LINE_BREAK);
			System.out.println(Constants.FIGHT_CHOOSE);

			String input = wrapper.getStringInput();

			switch (input) {
			case "1":
				int correctAns = createQuestion(enemy.getDifficultyLevel());
				if (isAnswerCorrect(correctAns)) {
					enemyStrength -= 40;
				} else {
					character.updateStrengthPoints(-40);
				}
				break;
			default:
				return;
			}
		}
		if (enemyStrength <= 0) {
			character.incrementExperience();
			System.out.println(Constants.WIN);
			drawer.printAsciiImage("YOU WIN");
			character.incrementLevel();
		} else {
			System.out.println(Constants.LOSE);
			drawer.printAsciiImage("YOU LOSE");
			wrapper.getStringInput();
			return;
		}
	}

	public int createQuestion(int difficultyLevel) {
		Random random = new Random();
		int rand1 = random.nextInt(difficultyLevel);
		int rand2 = random.nextInt(difficultyLevel);

		String randOp = operators.get(random.nextInt(operators.size()));

		int correctAns = 0;

		switch (randOp) {
		case "+":
			correctAns = rand1 + rand2;
			break;
		case "-":
			correctAns = rand1 - rand2;
			break;
		case "*":
			correctAns = rand1 * rand2;
			break;
		}

		System.out.println("What is " + rand1 + " " + randOp + " " + rand2 + "?");
		return correctAns;
	}

	public boolean isAnswerCorrect(int correctAns) {
		long startTime = System.currentTimeMillis();
		String input = wrapper.getStringInput();
		long endTime = System.currentTimeMillis();

		if (endTime - startTime > 20000) {
			System.out.println(Constants.TIME_EXCEEDED);
			return false;
		}

		try {
			if (correctAns == Integer.parseInt(input)) {
				System.out.println(Constants.PUNCH);
				return true;
			} else {
				System.out.println(Constants.BLEED);
				return false;
			}
		} catch (NumberFormatException e) {
			System.out.println(Constants.BLEED);
			return false;
		}
	}
}
