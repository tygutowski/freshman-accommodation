/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */

public final class Main {
	public static void main(String[] args) {
		MenuManager.enterMenu(new LoginMenu());
		MenuManager.mainLoop();
	}
}
