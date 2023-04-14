/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class MainMenu extends MenuBase {
	public MainMenu() {
		addOption(this::doExampleMenu, // handler
				 "exampleMenu",        // name
				 "Open example menu",  // description
				 (List<String>)null,
				 (List<String>)null);      // arguments (list)
		addOption(this::doExampleMenu, // handler
				 "test",        // name
				 "argument test",  // description
				 (List<String>) Arrays.asList("arg1", "arg2"),
				 (List<String>) Arrays.asList("desc1", "description2"));      // arguments (list)
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
