/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */


import java.util.HashMap;

public final class MainMenu extends MenuBase {
	public MainMenu() {
		addOption(this::doExampleMenu, // handler
				 "exampleMenu",        // name
				 "Open example menu",  // description
				 (String[])null);      // arguments (list)
	}

	public String getName() {
		return "Main Menu";
	}
	
	/**
	 * Example menu command handler
	 */
	private Void doExampleMenu(final HashMap<String, String> args) {
	    MenuManager.enterMenu(new ExampleMenu());

	    // Necessary because of the "Void" type
	    return null;
	}
}
