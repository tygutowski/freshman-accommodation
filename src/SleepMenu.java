/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.time.LocalTime;

/**
 * Menu for sleep schedule use case (#4)
 */
public final class SleepMenu extends MenuBase {
    /**
     * Dummy data because this application does not yet actually integrate with Canvas
     */
    private static final LinkedList<Course> s_dummyCanvasData
        = new LinkedList<Course>(List.of(
                // CSE4083, 10:00-10:50 MWF
                new Course("CSE4083", LocalTime.of(10, 00),
                        Course.Day.Monday, Course.Day.Wednesday, Course.Day.Friday),
                // CSE4251, 2:00-2:50 MWF
                new Course("CSE4251", LocalTime.of(14, 00),
                        Course.Day.Monday, Course.Day.Wednesday, Course.Day.Friday),
                // CSE3100, 3:00-3:50 M
                new Course("CSE3100", LocalTime.of(15, 00),
                        Course.Day.Monday),
                // BIO1040, 5:00-7:50 W
                new Course("BIO1040", LocalTime.of(17, 00),
                        Course.Day.Wednesday),
                // CSE3421, 9:30-10:45 TR
                new Course("CSE3421", LocalTime.of(9, 30),
                        Course.Day.Tuesday, Course.Day.Thursday),
                // OCN1010, 11:00-12:15 TR
                new Course("OCN1010", LocalTime.of(11, 00),
                        Course.Day.Tuesday, Course.Day.Thursday),
                // HUM3333, 12:30-01:45 TR
                new Course("OCN1010", LocalTime.of(12, 30),
                        Course.Day.Tuesday, Course.Day.Thursday)
          ));

    // Sleep schedule
    private SleepSchedule m_schedule = new SleepSchedule();
    
	public SleepMenu() {
		addOption(this::doImport,                // handler
				  "import",                      // name
				  "Import courses from Canvas"); // description     
		
        addOption(this::doView,     // handler
                  "view",           // name
                  "View schedule"); // description   
		
        addOption(this::doSetSleepTime,    // handler
                  "setSleepTime",          // name
                  "Set target sleep time", // description    
                  // arguments(list)
                  new Arg("sleepTime", "Target sleep time in hours (default is 8)"));
        
        addOption(this::doSetPrepTime,                      // handler
                  "setPrepTime",                            // name
                  "Set morning preparation + commute time", // description    
                  // arguments(list)
                  new Arg("prepTime", "Preparation time in minutes (default is 60)"));
	}
	
	public String getName() {
	    return "Sleep Schedule Manager";
	}
	
	/**
	 * Import command handler
	 */
	private Boolean doImport(final HashMap<String, String> args) {
	    // Empty schedule
	    m_schedule.clear();
	    
	    // We aren't yet integrated with Canvas, so we use sample data
	    for (final Course c : s_dummyCanvasData) {
	        m_schedule.addCourse(c);
	    }
	    
	    System.out.println("Imported data from Canvas into schedule");
	    
		return false;
	}
	
    /**
     * View schedule command handler
     */
    private Boolean doView(final HashMap<String, String> args) {
        if (!m_schedule.hasCourses()) {
            System.out.println("Sleep schedule has no courses.");
            System.out.println("Import your courses from Canvas using the \"import\" command.");
            return false;
        }
        
        System.out.println("===================================");
        System.out.println("Sleep Schedule");
        System.out.println("===================================");
        m_schedule.print();

        return false;
    }
	
    /**
     * Set sleep time command handler
     */
    private Boolean doSetSleepTime(final HashMap<String, String> args) {
        if (!m_schedule.hasCourses()) {
            System.out.println("Sleep schedule has no courses.");
            System.out.println("Import your courses from Canvas using the \"import\" command.");
            return false;
        }

        try {
            // Parse sleep time integer
            final int sleepTime = Integer.parseInt(args.get("sleepTime"));
            // Invalid sleep time
            if (sleepTime < 0 || sleepTime > 24) {
                return true;
            }

            m_schedule.setSleepTime(sleepTime);
            return false;
        }
        catch (NumberFormatException e) {
            // Bad input value, show usage again
            return true;
        }
    }
    
    /**
     * Set prep time command handler
     */
    private Boolean doSetPrepTime(final HashMap<String, String> args) {
        if (!m_schedule.hasCourses()) {
            System.out.println("Sleep schedule has no courses.");
            System.out.println("Import your courses from Canvas using the \"import\" command.");
            return false;
        }

        try {
            // Parse prep time integer
            final int prepTime = Integer.parseInt(args.get("prepTime"));
            // Invalid prep time
            if (prepTime < 0 || prepTime / 60 > 24) {
                return true;
            }

            m_schedule.setPrepTime(prepTime);
            return false;
        }
        catch (NumberFormatException e) {
            // Bad input value, show usage again
            return true;
        }
    }
}
