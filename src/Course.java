/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */

import java.time.LocalTime;

/**
 * Student course
 */
public final class Course {
    public enum Day {
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
    };
    
    public static int NUM_DAYS = Day.values().length;
    
    // Course name
    public final String name;
    // Time at which the course meets
    public final LocalTime meetTime;
    // Days on which the course meets
    public final int meetDays;
    
    public Course(final String name, final LocalTime meetTime,
            final Day... days) {
        this.name = name;
        this.meetTime = meetTime;
        
        // Build bitfield
        int meetDays = 0;
        assert days != null : "Course must meet on some day!";
        for (final Day d : days) {
            assert d.ordinal() < NUM_DAYS;
            meetDays |= (1 << d.ordinal());
        }
        
        this.meetDays = meetDays;
    }
    
    /**
     * Check whether the course meets on a specific day
     */
    public boolean isMeetOn(final Day d) {
        assert d.ordinal() < NUM_DAYS;
        return (this.meetDays & (1 << d.ordinal())) != 0;
    }
}
