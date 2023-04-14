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
			System.out.print("Enter command: ");

			// Wait for input
			while (!s_scanner.hasNextLine()) {
				;
			}

			clearScreen();
			
			// Split user command into tokens
			final String line = s_scanner.nextLine();
			final LinkedList<String> tokens = new LinkedList<String>();
			
			String currToken = "";
			boolean inQuotes = false;
			for (int i = 0; i < line.length(); i++) {
			    final char c = line.charAt(i);
			    
			    // Quoted terms are not split by whitespace
			    if (c == '\"') {
			        inQuotes = !inQuotes;
			    }
			    // Whitespace ends token (unless it is inside quotes)
			    else if (!inQuotes && c == ' ' && !currToken.isBlank()) {
			        tokens.add(currToken);
			        currToken = "";
			    }
			    // Part of token
			    else {
			        currToken += c;
			    }
			}
			// Last token
			tokens.add(currToken);
			
			// Unbalanced quotes
			if (inQuotes) {
			    continue;
			}
			
			if (tokens.size() > 0) {
				final String cmd = tokens.remove(0);
				
				// Show usage if invalid command is entered
				if (!s_menuStack.peek().doCommand(cmd, tokens)) {
				    showUsage();
				}
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
	    clearScreen();
	    
		assert menu != null;
		s_menuStack.push(menu);
		
		// Show usage of new menu
		s_menuStack.peek().showUsage();
	}

	/**
	 * Exit to previous menu
	 */
	public static void exitMenu() {
	    clearScreen();
	    
		assert s_menuStack.size() > 1 : "Can't exit root menu";
		s_menuStack.pop();
		
		
        // Show usage of new menu (if it exists)
		if (s_menuStack.peek() != null) {
		    s_menuStack.peek().showUsage();   
		}
	}
	
	/**
	 * Clear console text
	 */
	private static void clearScreen() {
	    try {
	        // Check for Windows OS
	        if (System.getProperty("os.name").contains("Windows")) {
	            // Run cls command
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        }
	        else {
	            // Not Windows, try ANSI escape codes
	            System.out.print("\033[H\033[2J");  
	            System.out.flush();     
	        }
	    }
	    catch (Exception e) {
	        ;
	    }
	}
}
