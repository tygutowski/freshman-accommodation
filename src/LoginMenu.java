/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class LoginMenu extends MenuBase {
	public LoginMenu() {
		addOption(this::tryLogin, // handler
				 "login",        // name
				 "Login to account",  // description
				 new Arg("user", "Student username [jsmith9999]"),
				 new Arg("pass", "Student password"));      // arguments (list)
	}

	public String getName() {
		return "Login Menu";
	}
	
	/**
	 * Example menu command handler
	 */
	private Void doExampleMenu(final HashMap<String, String> args) {
	    MenuManager.enterMenu(new ExampleMenu());

	    // Necessary because of the "Void" type
	    return null;
	}
	private Boolean tryLogin(final HashMap<String, String> args) {
		
	}
}
