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
public class Planner {
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
        final LinkedList<Assignment> due = new LinkedList<>();
        final Date dateNow = Assignment.date(date);

        if (dateNow != null) {
            for (final Assignment asst : m_assts) {
                if (asst.dueDate.compareTo(dateNow) == 0) {
                    due.add(asst);
                }
            }   
        }
        
        return due;
    }
}
