/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */

import java.util.HashMap;

/**
 * Menu for example use case
 */
public final class ExampleMenu extends MenuBase {
	public ExampleMenu() {
		addOption(this::doPrintStudent,                // handler
				 "printStudent",                       // name
				 "Print supplied student information", // description
				 "name", "email");                     // arguments (list)
	}
	
	public String getName() {
	    return "Example Menu";
	}
	
	/**
	 * Handler for printStudent option
	 * @param args Arguments supplied by the user
	 */
	private Void doPrintStudent(final HashMap<String, String> args) {
		final String name = args.get("name");
		final String email = args.get("email");
		System.out.printf("Student %s has email %s%n", name, email);

		// Necessary because of the "Void" type
		return null;
	}
}
