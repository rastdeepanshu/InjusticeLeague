package com.injusticeleague.main;

import com.injusticeleague.utils.Constants;
import com.injusticeleague.utils.ImageDrawer;
import com.injusticeleague.utils.ScannerWrapper;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ScannerWrapper wrapper = new ScannerWrapper(scanner);

		ImageDrawer drawer = new ImageDrawer();
		drawer.printAsciiImage("INJUSTICE");
		drawer.printAsciiImage("LEAGUE");
		System.out.println(Constants.LINE_BREAK);
		System.out.println(Constants.WELCOME);
		System.out.println(Constants.PLOT);
		System.out.println(Constants.LINE_BREAK);

		MAIN: while (true) {
			System.out.println(Constants.CHOOSE);

			String input1 = wrapper.getStringInput();

			switch (input1) {
			case "1":
				Game game = new Game(wrapper);
				game.startGame();
				break;
			case "2":
				Game game2 = new Game(wrapper);
				game2.resumeGame();
				break;
			case "3":
				System.out.println(Constants.THANKS);
				break MAIN;
			default:
				System.out.println(Constants.INVALID_INPUT);
				break;
			}
		}
	}
}
