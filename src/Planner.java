/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */

import java.util.Date;
import java.util.LinkedList;

/**
 * Student planner for course assignments and other important events
 */
public final class Planner {
    // Assignments in planner
    private LinkedList<Assignment> m_assts = new LinkedList<>();

    /**
     * Clear all assignments from the planner
     */
    public void clear() {
        m_assts.clear();
    }
    
    /**
     * Add assignment to planner
     */
    public void addAsst(final Assignment asst) {
        m_assts.add(asst);
    }
    
    /**
     * Remove assignment from planner
     * @param course Assignment course
     * @param name Assignment name
     */
    public boolean removeAsst(final String course, final String name) {
        // Find assignment with matching course/name
        for (int i = 0; i < m_assts.size(); i++) {
            final Assignment asst = m_assts.get(i);
            
            if (asst.course.equals(course) && asst.name.equals(name)) {
                m_assts.remove(i);
                return true;
            }
        }
        
        // Could not remove
        return false;
    }
    
    /**
     * Get all assignments due on the specified date
     * @param date Specified date (MUST BE mm/dd/yyyy format)
     */
    public LinkedList<Assignment> dueOnDate(final String date) {
        // No due date specified = get all assignments
        if (date == null) {
            return m_assts;
        }
        
        final LinkedList<Assignment> due = new LinkedList<>();
        final Date dateNow = Assignment.str2date(date);

        if (dateNow != null) {
            for (final Assignment asst : m_assts) {
                if (asst.dueDate.equals(dateNow)) {
                    due.add(asst);
                }
            }   
        }
        
        return due;
    }
    
    /**
     * Print planner to console
     */
    public void print() {
        // No assignments
        if (m_assts.size() == 0) {
            System.out.println("Planner is empty! Go relax :)");
        }
        else {
            // Hopefully you never have something due before 2000 or this will break
            Date lastDate = Assignment.str2date("1/1/2000");
            
            for (final Assignment asst : m_assts) {
                // Separate assignments by date
                if (asst.dueDate.after(lastDate)) {
                    lastDate = asst.dueDate;
                    
                    System.out.printf("Due on %s%n",
                            Assignment.date2str(asst.dueDate));
                }
                
                System.out.printf("  %s - %s%n", asst.course, asst.name);
            }
        }
    }
}
