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
    protected String department = "";
    
    /**
     * An alphanumeric string representing the course number. For example, 
     * "232" or "110M."
     */
    protected String number = "";

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
    protected String days = "";

    /**
     * The range of time for the class (e.g., 10am to 11am).
     */
    protected TimeRange time;

    /**
     * The abbreviation for the building (e.g., "AH" for "Ayers Hall").
     */
    protected String building = "" ;

    /**
     * The alphanumeric room number (e.g., "214" or "105C").
     */
    protected String room = "";

    /**
     * The last name of the faculty member teaching the course (e.g., "Garrett").
     */
    protected String faculty = "";

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
        this.department = department.toUpperCase();
        this.number = number.toUpperCase();
        this.section = section;
    }

    public String getDepartment() {
        return department.toUpperCase();
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getNumber() {
        return number.toUpperCase();
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    public int getSection() {
        return section;
    }
    
    /**
     * The section must be greater than 0.
     */
    public void setSection(int section) {
        if (section > 0){
            this.section = section;
        }
    }
    
    public String getDays() {
        return days.toUpperCase();
    }

    /**
     * The days must be converted to uppercase.
     */
    public void setDays(String days) {
        this.days = days.toUpperCase();
    }

    public TimeRange getTime() {
        return time;
    }
    
    public void setTime(TimeRange time) {
        this.time = time;
    }
    
    public String getBuilding() {
        try{
            return building;
        } catch(NullPointerException e){
            return "";
        }
        
    }
    
    public void setBuilding(String building) {
        this.building = building.toUpperCase();
    }
    
    public String getRoom() {
        return room.toUpperCase();
    }
    
    public void setRoom(String room) {
        this.room = room.toUpperCase();
    }
    
    public String getFaculty() {
        return faculty;
    }
    
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    /**
     * The capacity must be greater than or equal to 0.
     */
    public void setCapacity(int capacity) {
        if (capacity >= 0){
            this.capacity = capacity;
        }
    }
    
    public int getEnrolled() {
        return enrolled;
    }
    
    /**
     * The enrolled must be greater than or equal to 0.
     */
    public void setEnrolled(int enrolled) {
        if(enrolled >= 0){
            this.enrolled = enrolled;
        }
    }

    /**
     * This method returns true if the enrollment is greater than or equal 
     * to the capacity.
     * 
     * @return whether the course is full
     */
    public boolean isFull() {
        if (enrolled >= capacity){
            return true;
        }
        return false;
    }

    /**
     * This method returns true if the course meets on the given day.
     * 
     * @param day the day of the week
     * @return whether the course meets on the given day
     */
    public boolean meetsOn(Day day) {
        String allDays = "NMTWRFS";
        int index = 0;
        for (Day s: Day.values()){
            if (s == day){
                if(days.contains("" +allDays.charAt(index))){
                    return true;
                }
            }
            index++;
        }
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
        String[] allDays = days.split("");
        for(String i : allDays){
            if (course.getDays().contains(i) && time.overlaps(course.getTime())){
                return true;
            }
        }
            
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
        return department + " " + number + " " + section + " " + days + " " + time.getStartTime().toString() + " " + time.getEndTime().toString() + " " + building
        + " " + room + " " + faculty + " " + capacity + " " + enrolled;
    }
}