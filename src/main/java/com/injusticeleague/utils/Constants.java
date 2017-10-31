package com.injusticeleague.utils;

import java.io.File;

public class Constants {

	public static final String LINE_BREAK = "--------------------------------------------------------------\n";

	public static final String WELCOME = "\nWelcome to Injustice League\n";

	public static final String PLOT = "\nIt was a great time. Justice league had defeated the greatest devil in the "
			+ "entire universe, DARKSEID.\nEveryone was celebrating and thanking god for these amazing heroes. "
			+ "But soon enough, everything changed.\nThe heroes turned corrupt and slowly bacame the greatest threat "
			+ "to humans. They turned everyone into their slaves and did whatever they wanted to.\n"
			+ "Many people with some abilities tried to fight them but failed. "
			+ "Can you save the people from the wrath of these super \"villains\"?\n";

	public static final String CHOOSE = "\nChoose an option:\n\t1: Start your journey\n\t2: Continue your journey\n\t"
			+ "3: Quit\n";

	public static final String CHOOSE_GAME_START = "\nChoose an option:\n\t1: Create character\n\t2: Play\n\t3: "
			+ "Go back\n";

	public static final String THANKS = "\nThanks for playing Injustice League\n";

	public static final String INVALID_INPUT = "\nInvalid Input. Please give the correct input.\n";

	public static final String CHAR_NAME = "\nGive your character a name.";

	public static final String CHAR_DESC = "\nDescribe your character. A short bio.";

	public static final String CHOOSE_GENDER = "\nChoose gender:\n\t1: MALE\n\t2: FEMALE\n";

	public static final String POWERS_RULES = "\nNow its the time to give your character some powers.\nEvery power"
			+ " is associated with some points, which will eventually be the strength points of your character."
			+ "Choose any 5 of these 7 powers, one by one.\n";

	public static final String CHOOSE_POWERS = "\nChoose powers:\n\t1: Fly\n\t2: Breathe under water\n\t3: "
			+ "Dodge bullets\n\t4: Is rich\n\t5: Run fast\n\t6: Change weather\n\t7: Can shoot laser through eyes.\n";

	public static final String POWER_PRESENT = "\nCharacter already contains this power.";

	public static final String GAMEPLAY_CHOOSE = "\nChoose and option:\n\t1: Explore Maps\n\t2: Fight next opponent\n\t"
			+ "3: Save\n\t4: Go back\n";

	public static final String MAP_INFO = "\nEvery map contains some hidden bonuses. But BEWARE!\n"
			+ "Not all bonuses are good for your health. So open them at your own risk!!!";

	public static final String CHOOSE_MAP = "\nChoose Map:\n\t1: Mighty Mountains\n\t2: Dangerous Desert\n\t"
			+ "3: Simple Sea\n\t4: Corrupt City\n\t5: Go back\n";

	public static final String BONUS = "\n\tPress 1 to open\n\tAnything else to go back\n";

	public static final String NO_BONUS = "\nSorry! No bonus this time.\n";

	public static final String BONUS_REMAINING = "\nRemaining bonuses: ";

	public static final String FIGHT_RULES = "\nSolve the questions within 20 sec to win the round.\n"
			+ "For every correct answer, you do 25 damage. For every incorrect answer, you take 25 damage.\n" +
			"As you move up the ladder, the difficulty of questions increases."
			+ "The more matches you win, the more experience points you get which increases your strength.";

	public static final String FIGHT_CHOOSE = "\n\tPress 1 to attack\n\tAny other key to accept defeat and go back.\n";

	public static final String PUNCH = "\nYou gave an amazing blow to the enemy\n";

	public static final String BLEED = "\nDamn!! you took a nasty blow\n";

	public static final String TIME_EXCEEDED = "\nTime limit exceeded";

	public static final String WIN = "\n*********** You won!! You defeated the enemy! ***********";

	public static final String LOSE = "\n*********** You have been dusted! ***********\n\n"
			+ "You are dead. Input anything to continue\n";

	public static final int WIDTH = 150;

	public static final int HEIGHT = 30;

	private static final String homePath = System.getProperty("user.home");

	private static final String PATH_SEPARATOR = File.separator;
	
	public static final String FILE_NAME = homePath + PATH_SEPARATOR + "Injusticeleague.savegame";

	public static final String NO_SAVE = "\n---- No saved game found ----\n";
	
	public static final String GAME_SAVED = "\n---- Progress saved ----\n";

	public static final String ERROR = "\nError while accessing resource\n";

	public static final String WORLD_SAVED = "You have defeated all the enemies and saved the planet. You are the real hero!";
}
