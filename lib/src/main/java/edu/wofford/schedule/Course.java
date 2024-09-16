/**
 * This class represents most of the relevant course information for scheduling 
 * purposes. (Prerequisites, in particular, are not included for simplicity.) 
 * This class should allow programmers to determine whether a Course object is 
 * full (meaning that its enrollment is at capacity), if it meets on a 
 * particular day, and if it conflicts with another course (meaning that its 
 * day and time conflict with the other course's day and time).
 */

package edu.wofford.schedule;


public class Course {
    /**
     * This enumeration represents the days of the week that can be 
     * used to determine whether the course meets on a particular day.
     * Legitimate values are SUN, MON, TUE, WED, THU, FRI, SAT.
     */
    public enum Day {SUN, MON, TUE, WED, THU, FRI, SAT};
    
    /**
     * A two- or three-letter designation for a department. For example, 
     * "CS" represents "computer science."
     */
    protected String department;
    
    /**
     * An alphanumeric string representing the course number. For example, 
     * "232" or "110M."
     */
    protected String number;

    /**
     * A positive integer representing the section number.
     */
    protected int section;

    /**
     * A string representing the days of the week on which the course meets, 
     * where each day is represented by a single character. The days of the 
     * week from Sunday through Saturday would be represented as "NMTWRFS". 
     * These designations should be capital letters.
     */
    protected String days;

    /**
     * The range of time for the class (e.g., 10am to 11am).
     */
    protected TimeRange time;

    /**
     * The abbreviation for the building (e.g., "AH" for "Ayers Hall").
     */
    protected String building;

    /**
     * The alphanumeric room number (e.g., "214" or "105C").
     */
    protected String room;

    /**
     * The last name of the faculty member teaching the course (e.g., "Garrett").
     */
    protected String faculty;

    /**
     * The maximum capacity for the course.
     */
    protected int capacity;

    /**
     * The current number of students enrolled in the course.
     */
    protected int enrolled;

    
    /**
     * This constructor requires the department, course number, and section.
     */
    public Course(String department, String number, int section) {

    }

    public String getDepartment() {
        return "";
    }
    
    public void setDepartment(String department) {

    }
    
    public String getNumber() {
        return "";
    }
    
    public void setNumber(String number) {

    }
    
    public int getSection() {
        return -1;
    }
    
    /**
     * The section must be greater than 0.
     */
    public void setSection(int section) {

    }
    
    public String getDays() {
        return "";
    }

    /**
     * The days must be converted to uppercase.
     */
    public void setDays(String days) {

    }

    public TimeRange getTime() {
        return null;
    }
    
    public void setTime(TimeRange time) {

    }
    
    public String getBuilding() {
        return "";
    }
    
    public void setBuilding(String building) {

    }
    
    public String getRoom() {
        return "";
    }
    
    public void setRoom(String room) {

    }
    
    public String getFaculty() {
        return "";
    }
    
    public void setFaculty(String faculty) {

    }
    
    public int getCapacity() {
        return -1;
    }
    
    /**
     * The capacity must be greater than or equal to 0.
     */
    public void setCapacity(int capacity) {

    }
    
    public int getEnrolled() {
        return -1;
    }
    
    /**
     * The enrolled must be greater than or equal to 0.
     */
    public void setEnrolled(int enrolled) {

    }

    /**
     * This method returns true if the enrollment is greater than or equal 
     * to the capacity.
     * 
     * @return whether the course is full
     */
    public boolean isFull() {
        return false;
    }

    /**
     * This method returns true if the course meets on the given day.
     * 
     * @param day the day of the week
     * @return whether the course meets on the given day
     */
    public boolean meetsOn(Day day) {
        return false;
    }

    /**
     * This method returns true if the current course conflicts with the 
     * course that is passed in. A course conflicts with another if both 
     * meet on the same day and the time ranges overlap.
     * 
     * @param course the course in question
     * @return whether the current course conflicts with the course parameter
     */
    public boolean conflictsWith(Course course) {
        return false;
    }

    /**
     * This method returns the string representation of the course. For example, 
     * a string representation of a course would look like the following:
     * 
     * CS 232 1 MWF 1230 1400 AH 363 Garrett 15 14
     * 
     * @return the string representation of the course
     */
    public String toString() {
        return "";
    }
}