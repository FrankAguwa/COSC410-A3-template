/**
 * This class represents a set of course offerings. It should allow the 
 * programmer to construct an empty object with a capacity of 100 courses 
 * or construct an object from an input file. It should also allow courses 
 * to be accessed, changed, and added.
 */

package edu.wofford.schedule;
 
import java.io.*;
import java.util.Scanner;
 
public class CourseOfferings {
    protected Course[] courses;  // an array of courses with at most 100 elements
    protected int numCourses;    // the actual number of courses in the courses array


    /**
     * This is a constructor that creates an array of 100 courses and 
     * initializes the number of courses to 0.
     */
    public CourseOfferings() {
        courses = new Course[100];
        numCourses = 0;

    }

    /**
     * This is a constructor that creates an array of 100 courses and fills it 
     * with the courses listed in the input file that is passed in. 
     * The format (and sample) of the input file is as follows:
     * 
     * CS 230 1 MWF 1000 1130 AH 257 DaParma 20 18
     * CS 230 2 MWF 0815 0945 AH 257 Thornton 20 18
     * CS 230 3 TWR 1245 1415 AH 363 Ford 20 12
     * CS 230 4 MWF 1300 1430 AH 361 DaParma 20 18
     * CS 230 5 TWR 1500 1629 AH 363 Garrett 20 14
     * CS 231 1 TWR 0915 1045 AH 363 Ford 20 11
     * CS 231 2 TWR 1245 1415 AH 257 Reaves 20 20
     * CS 232 1 MWF 1230 1400 AH 363 Garrett 15 14
     * CS 232 2 MWF 1630 1800 AH 363 Garrett 15 5
     */
    public CourseOfferings(File file) {
        courses = new Course[100];
        numCourses = 0;
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] courseArray = line.split(" ");
                Course courseTrack = new Course(courseArray[0], courseArray[1], Integer.parseInt(courseArray[2]));
                courseTrack.setDays(courseArray[3]);
                Time start = new Time(courseArray[4]);
                Time end = new Time(courseArray[5]);
                TimeRange time = new TimeRange(start, end);
                courseTrack.setTime(time);
                courseTrack.setBuilding(courseArray[6]);
                courseTrack.setRoom(courseArray[7]);
                courseTrack.setFaculty(courseArray[8]);
                courseTrack.setCapacity(Integer.parseInt(courseArray[9]));
                courseTrack.setEnrolled(Integer.parseInt(courseArray[10]));
                courses[numCourses] = courseTrack;
                numCourses++;
            }
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
        // for (int i = 0; i < courses.length; i++){
        //     System.out.println(courses[i] + "COURSE LIST");
        // }
        
    }

    /**
     * This method returns the number of courses currently held in the array.
     * 
     * @return the number of courses
     */
    public int getNumCourses() {
        return numCourses;
    }
    /**
     * This method returns the course at index i. If i is not within the 
     * legal bounds of the array (less than 0 or greater than or equal to 
     * the current number of courses), an ArrayIndexOutOfBoundsException 
     * should be thrown.
     * 
     * @param i the index of the course to retrieve
     * @return the course at index i
     */
    public Course getCourse(int i){
        if (i < 0 || i >= numCourses){
            throw new ArrayIndexOutOfBoundsException("Number out of Bounds");
        }
            return courses[i];
        
        
    }

    /**
     * This method sets the course at index i to c. If i is not within the 
     * legal bounds of the array (less than 0 or greater than or equal to 
     * the current number of courses), an ArrayIndexOutOfBoundsException 
     * should be thrown.
     * 
     * @param i the index of the course
     * @param c the course that should replace the one at index i
     */
    public void setCourse(int i, Course c) {
        if (i < 0 || i >= numCourses){
            throw new ArrayIndexOutOfBoundsException("Number out of Bounds");
        }
            courses[i] = c;
        
    }

    /**
     * This method adds the course c to the end of the array if there is room. 
     * It returns true if c could be added and false otherwise.
     * 
     * @param c the course to add
     * @return whether the course could be added
     */
    public boolean addCourse(Course c) {
        if (numCourses < 100){
            courses[numCourses] = c;
            numCourses++;
            return true;
        }
        return false;
    }

    /**
     * This method returns the string representation of the course offerings, 
     * which should look identical in format to the input file.
     * 
     * @return the string representation of the course offerings
     */
    public String toString() {
        String s = "";
        for (Course c: courses){
            if(c != null){
                s = s.concat(c.toString() + "\n");
            }
        }
       
        return s;
    }
}