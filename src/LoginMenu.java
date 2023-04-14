/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public final class LoginMenu extends MenuBase {
	
	public static Professor professor1 = new Professor("Phillip",
			                                           "Chan",
			                                           "pkchan@fit.edu",
			                                           true);
	public static Professor professor2 = new Professor("Siddhartha",
										               "Bhattacharyya",
										               "sbhattacharyya@fit.edu",
										               false);
	public static Professor professor3 = new Professor("William",
											           "Shoaff",
											           "wds@fit.edu",
											           false);
	
	public static Student student = null;
	public static Student student1 = new Student("Tyler",
			                                     "Gutowski",
			                                     "903643555",
			                                     "tgutowski2020@fit.edu",
			                                     (List<Professor>) Arrays.asList(professor2, professor3, professor3, professor3),
												 true);
	public LoginMenu() {
		addOption(this::tryLogin, // handler
				 "login",        // name
				 "Login to account",  // description
				 new Arg("user", "Student username [jsmith9999]"));      // arguments (list)
	}

	public String getName() {
		return "Login Menu";
	}
	
	private Boolean tryLogin(final HashMap<String, String> args) {
		if (args.get("user").equals("tgutowski2020")) {
			student = student1;
			MenuManager.enterMenu(new ApplicationMenu());
		}
		return false;
	}
}
