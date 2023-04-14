/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */


import java.util.LinkedList;
import java.util.HashMap;
import java.util.function.Function;
import java.util.List;

public abstract class MenuBase {
	// Menu options
	private final LinkedList<Option> m_options = new LinkedList<>();

	public MenuBase() {
		// All menus have an exit command
		addOption(this::doExit,   // handler
				"exit",           // name
				"Exit menu",      // description
				(List<String>)null,
				(List<String>)null); // arguments (list)
	}

	/**
	 * Menu name (must be implemented)
	 */
	public abstract String getName();

	/**
	 * Add menu option
	 * 
	 * @param callback Option callback
	 * @param name     Option name
	 * @param desc     Option description
	 * @param args     Option arguments
	 */
	public void addOption(final Function<HashMap<String, String>, Void> callback,
			final String name, final String desc, final List<String> args, final List<String> argDesc) {
		m_options.add(new Option(callback, name, desc, args, argDesc));
	}

	/**
	 * Show menu usage
	 */
	public void showUsage() {
		System.out.println(getName());
		System.out.println("===================================");
		System.out.println("Commands:");
		System.out.println();

		for (final Option o : m_options) {
			// Option name
			System.out.printf("%-20s %s\n", o.name, o.desc);

			// Option arguments
			if (o.args != null) {
				for(int i = 0; i < o.args.size(); i++) {
					System.out.printf("     %-15s %s\n", o.args.get(i), o.argDesc.get(i));
				}
			}
		}
	}

	/**
	 * Interpret command
	 * 
	 * @param tokens Command tokens
	 */
	public boolean doCommand(final String cmd, final List<String> args) {
		final HashMap<String, String> argsMap = new HashMap<>();

		// Find option corresponding to command
		Option option = null;
		for (final Option o : m_options) {
			if (o.name.equals(cmd)) {
				option = o;
				break;
			}
		}

		// Not a real command
		if (option == null) {
			return false;
		}

		// Pack arguments (if option has any)
		if (option.args != null) {
			// Make sure the argument count is correct
			if (args.size() != option.args.size()) {
				return false;
			}

			// Command is followed by arguments
			for (int i = 0; i < args.size(); i++) {
				argsMap.put(option.args.get(i), args.get(i));
			}
		}

		// Call option handler
		option.handler.apply(argsMap);

		return true;
	}

	/**
	 * Exit command handler
	 */
	private Void doExit(final HashMap<String, String> args) {
		MenuManager.exitMenu();
		return null;
	}
}
