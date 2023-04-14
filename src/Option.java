/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.lang.Override;

/**
 * Menu option
 */
public final class Option {
	// Option handler
	// - Handler argument is dictionary of command arguments
	// - Handler return value is Void (not "void", Java function pointers are strange)
	public final Function<HashMap<String, String>, Void> handler;

	// Option name
	public final String name;
	// Option description
	public final String desc;
	// Option arguments (their names)
	public final List<String> args;
	
	public Option(final Function<HashMap<String, String>, Void> handler,
			final String name, final String desc, final String... args) {
		this.handler = handler;
		this.name = name;
		this.desc = desc;
		this.args = args != null ? Arrays.asList(args) : null;
	}
}
