/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */

import java.util.HashMap;

/**
 * Main menu
 */
public final class MainMenu extends MenuBase {
	public MainMenu() {
		addOption(this::doExampleMenu,  // handler
				  "exampleMenu",        // name
				  "Open example menu"); // description

		addOption(this::doExampleMenu, // handler
				  "test",              // name
			   	  "argument test",     // description
				  // arguments (list)
				  new Arg("arg1", "description1"),
				  new Arg("arg2", "description2"));
	}

	public String getName() {
		return "Main Menu";
	}

	/**
	 * Example menu command handler
	 */
	private Boolean doExampleMenu(final HashMap<String, String> args) {
		MenuManager.enterMenu(new ExampleMenu());
		return false;
	}
}
