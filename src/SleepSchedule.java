/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */

import java.util.LinkedList;
import java.time.LocalTime;

public final class SleepSchedule {
    // Default sleep target is 8 hours
    private static final int DEFAULT_SLEEP_TIME = 8;
    // Default preparation time is 60 minutes
    private static final int DEFAULT_PREP_TIME = 60;
    
    // Student target sleep time (in hours)
    private int m_sleepTime = DEFAULT_SLEEP_TIME;
    // Student morning preparation + commute time (in minutes)
    private int m_prepTime = DEFAULT_PREP_TIME;
    // Student courses
    private final LinkedList<Course> m_courses = new LinkedList<>();
    // Student bed time each week day
    private final LocalTime[] m_bedTimes = new LocalTime[Course.NUM_DAYS];
    
    /**
     * Clear courses
     */
    public void clear() {
        m_courses.clear();
    }
    
    /**
     * Whether the sleep schedule has any courses
     */
    public boolean hasCourses() {
        return !m_courses.isEmpty();
    }
    
    /**
     * Set new target sleep time
     * @param sleepTime Sleep time (in hours)
     */
    public void setSleepTime(final int sleepTime) {
        if (!hasCourses()) {
            return;
        }
        
        assert sleepTime <= 24 : "Can't sleep more than 24 hours in a day";
        m_sleepTime = sleepTime;
    }
    
    /**
     * Set new prep time
     * @param prepTime Morning preparation + commute time (in minutes)
     */
    public void setPrepTime(final int prepTime) {
        if (!hasCourses()) {
            return;
        }

        assert prepTime / 60 <= 24 : "Can't prep for more than 24 hours in a day";
        m_prepTime = prepTime;
    }
    
    /**
     * Add course to schedule
     */
    public void addCourse(final Course c) {
        m_courses.add(c);
    }
    
    /**
     * Print sleep schedule to console
     */
    public void print() {
        calculate();

        System.out.printf("Target sleep time: %d hours%n", m_sleepTime);
        System.out.printf("Morning prep time: %d minutes (%.2f hours)%n", m_prepTime, m_prepTime / 60.0f);
        System.out.println("===================================");
        System.out.println("Daily sleep time:");
        System.out.println("(You can stay up the night before, at most this late)");
        System.out.println("===================================");
        
        // Week details
        for (final Course.Day day : Course.Day.values()) {
            System.out.printf("%s:%n", day.name());
            System.out.printf("  %s%n", m_bedTimes[day.ordinal()]);
        }
    }
    
    /**
     * Calculate sleep schedule
     */
    private void calculate() {        
        // Earliest meeting course on each day
        LocalTime[] earliest = new LocalTime[Course.NUM_DAYS];
        // Initialize values
        for (int i = 0; i < earliest.length; i++) {
            earliest[i] = LocalTime.MAX;
        }
        
        // Iterate over courses
        for (final Course c : m_courses) {
            // Check every day that the course *could* meet
            for (final Course.Day day : Course.Day.values()) {
                // Is this the earliest known course on this day?
                if (c.isMeetOn(day) && c.meetTime.isBefore(earliest[day.ordinal()])) {
                    earliest[day.ordinal()] = c.meetTime;
                }
            }
        }
        
        // From earliest courses, calculate bed time
        for (int i = 0; i < Course.NUM_DAYS; i++) {
            m_bedTimes[i] = earliest[i].minusHours(m_sleepTime).minusMinutes(m_prepTime);
        }
    }
}
