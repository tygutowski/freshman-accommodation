/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */

public final class Main2 {
	public static void main(String[] args) {
		// Start from example use case menu
		MenuManager.enterMenu(new MainMenu());

		// Process input
		MenuManager.mainLoop();
	}
}
