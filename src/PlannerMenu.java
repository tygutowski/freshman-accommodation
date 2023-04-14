/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Menu for planner manager use case (#3)
 */
public final class PlannerMenu extends MenuBase {
    /**
     * Dummy data because this application does not yet actually integrate with Canvas
     */
    private static final LinkedList<Assignment> s_dummyCanvasData
        = new LinkedList<Assignment>(List.of(
                // 3/30/2023
                new Assignment("BIO1040", "Quiz 6 - Squid & sea star", "3/30/2023"),
                new Assignment("CSE3421", "Group Assignment 4",        "3/30/2023"),
                // 4/11/2023
                new Assignment("CSE3421", "Iterator Pattern",          "4/11/2023"),
                new Assignment("CSE4083", "Pumping Lemmas",            "4/11/2023"),
                // 4/14/2023
                new Assignment("BIO1040", "Quiz 7 - Shark",            "4/14/2023"),
                new Assignment("CSE3421", "Group Assignment 5",        "4/14/2023"),
                // 4/18/2023
                new Assignment("OCN1010", "HW5",                       "4/18/2023"),
                new Assignment("CSE3421", "Exam 2",                    "4/18/2023")
          ));

    // Planner
    private Planner m_planner = new Planner();
    
	public PlannerMenu() {
		addOption(this::doImport,                    // handler
				  "import",                          // name
				  "Import assignments from Canvas"); // description     
		
        addOption(this::doView,    // handler
                  "view",          // name
                  "View planner"); // description   
		
        addOption(this::doAddAsst,             // handler
                  "addAsst",                   // name
                  "Add assignment to planner", // description    
                  // arguments(list)
                  new Arg("course", "Assignment course code"),
                  new Arg("name", "Assignment name"),
                  new Arg("date", "Assignment date (MUST BE mm/dd/yyyy format)"));
        
        addOption(this::doRemoveAsst,               // handler
                  "removeAsst",                     // name
                  "Remove assignment from planner", // description
                  // arguments(list)
                  new Arg("course", "Assignment course code"),
                  new Arg("name", "Assignment name"));
        
        addOption(this::doTestNotify,                            // handler
                  "testNotify",                                  // name
                  "Test notification system for specified date", // description    
                  // arguments(list)
                  new Arg("date", "Assignment date (MUST BE mm/dd/yyyy format)"));
	}
	
	public String getName() {
	    return "Planner Manager";
	}
	
	/**
	 * Import command handler
	 */
	private Boolean doImport(final HashMap<String, String> args) {
	    // Empty planner
	    m_planner.clear();
	    
	    // We aren't yet integrated with Canvas, so we use sample data
	    for (final Assignment asst : s_dummyCanvasData) {
	        m_planner.addAsst(asst);
	    }
	    
	    System.out.println("Imported data from Canvas into planner");
	    
		return false;
	}
	
    /**
     * View planner command handler
     */
    private Boolean doView(final HashMap<String, String> args) {   
        System.out.println("===================================");
        System.out.println("Planner");
        System.out.println("===================================");   
        m_planner.print();

        return false;
    }
	
    /**
     * Add assignment command handler
     */
    private Boolean doAddAsst(final HashMap<String, String> args) {
        final Assignment asst = new Assignment(args.get("course"),
                args.get("name"), args.get("date"));
        
        m_planner.addAsst(asst);
        System.out.println("Added assignment to planner");
        
        return true;
    }
    
    /**
     * Remove assignment command handler
     */
    private Boolean doRemoveAsst(final HashMap<String, String> args) {
        if (!m_planner.removeAsst(args.get("course"), args.get("name"))) {
            System.out.println("Failed to remove assignment from planner");
        }
        
        return false;
    }
    
    /**
     * Notification test command handler
     */
    private Boolean doTestNotify(final HashMap<String, String> args) {
        // Get assignments due that day
        final LinkedList<Assignment> due = m_planner.dueOnDate(args.get("date"));
        
        System.out.println("===================================");
        System.out.println("Assignments due today:");
        System.out.println("===================================");   
        
        // No assignments
        if (due.size() == 0) {
            System.out.println("Nothing is due today! Go relax :)");
        }
        else {
            for (final Assignment asst : due) {
                System.out.printf("%s - %s%n", asst.course, asst.name);
            }
        }
        
        return false;
    }
}
