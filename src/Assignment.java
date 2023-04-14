/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Course assignment
 */
public final class Assignment {
    public final String course;
    public final String name;
    public final Date dueDate;
    
    public Assignment(final String course, final String name,
            final String dueDate) {
        this.name = name;
        this.course = course;
        this.dueDate = str2date(dueDate);
    }
    
    /**
     * Create date object from month, day, year
     * @param s Date string must be in mm/dd/yyyy format
     */
    public static Date str2date(final String s) {
        final SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
        
        try {
            return fmt.parse(s);
        }
        catch (ParseException e) {
            return null;
        }
    }
    
    /**
     * Convert Java Date object to string (mm/dd/yyyy)
     * @param d Date object
     */
    @SuppressWarnings("deprecation")
    public static String date2str(final Date d) {
        return String.format("%02d/%02d/%04d",
                d.getMonth() + 1, d.getDate(), d.getYear() + 1900);
    }
}
