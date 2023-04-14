/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Menu manager (static class)
 */
public final class MenuManager {
	// Menu hierarchy
	private static final LinkedList<MenuBase> s_menuStack = new LinkedList<>();
	// User input scanner
	private static final Scanner s_scanner = new Scanner(System.in, "US-ASCII");

	public MenuManager() {
		assert false : "Don't construct this class";
	}

	/**
	 * Whether any menu is open
	 */
	public static boolean isRunning() {
		return s_menuStack.size() > 0;
	}

	/**
	 * Menu update loop
	 */
	public static void mainLoop() {
		while (isRunning()) {
			System.out.println();
			System.out.print("Enter command: ");

			// Wait for input
			while (!s_scanner.hasNextLine()) {
				;
			}

			// Split user command into tokens
			final String line = s_scanner.nextLine();
			final LinkedList<String> tokens = new LinkedList<String>(Arrays.asList(line.split("\\s+")));

			if (tokens.size() > 0) {
				final String cmd = tokens.remove(0);

				assert isRunning() : "No menu is open";
				s_menuStack.peek().doCommand(cmd, tokens);
			}
		}
	}

	/**
	 * Show usage of current menu
	 */
	public static void showUsage() {
		assert isRunning() : "No menu is open";
		s_menuStack.peek().showUsage();
	}

	/**
	 * Enter new menu
	 * 
	 * @param menu New menu
	 */
	public static void enterMenu(final MenuBase menu) {
		assert menu != null;
		s_menuStack.push(menu);
		
		// Show usage of new menu
		s_menuStack.peek().showUsage();
	}

	/**
	 * Exit to previous menu
	 */
	public static void exitMenu() {
		assert s_menuStack.size() > 1 : "Can't exit root menu";
		s_menuStack.pop();
		
		
        // Show usage of new menu (if it exists)
		if (s_menuStack.peek() != null) {
		    s_menuStack.peek().showUsage();   
		}
	}
}
