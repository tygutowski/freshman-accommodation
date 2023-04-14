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
		// Exit command for exiting to the previous menu
		addOption(this::doExit, // handler
			      "exit",       // name
			      "Exit menu"); // description
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
	public void addOption(final Function<HashMap<String, String>, Boolean> callback,
			final String name, final String desc, final Arg... args) {
		m_options.add(new Option(callback, name, desc, args));
	}

	/**
	 * Show menu usage
	 */
	public void showUsage() {
	    System.out.println("===================================");
		System.out.println(getName());
		System.out.println("===================================");
		System.out.println("Commands:");
		System.out.println();

		for (final Option o : m_options) {
			// Option name
			System.out.printf("%-20s %s\n", o.name, o.desc);

			// Option arguments
			if (o.args != null) {
				for (int i = 0; i < o.args.size(); i++) {
				    final Arg arg = o.args.get(i);
					System.out.printf("  %-18s %s\n", arg.name, arg.desc);
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
				argsMap.put(option.args.get(i).name, args.get(i));
			}
		}

		// Call option handler
		option.handler.apply(argsMap);

		return true;
	}

	/**
	 * Exit command handler
	 */
	private Boolean doExit(final HashMap<String, String> args) {
		MenuManager.exitMenu();
		return false;
	}
}
