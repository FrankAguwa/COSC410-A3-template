
package edu.wofford.schedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Course x;
    Course y;
    Course z;

    @BeforeEach
    public void setUp() {
        // Setup code here (if required)
        x = new Course("COSC", "235", 1);
        y = new Course("COSC", "350", 2);
        z = new Course("COSC", "350", 1);

        x.setDays("MWf");
        x.setTime(new TimeRange(new Time(11, 0), new Time(12, 30)));
        x.setBuilding("OLIN");
        x.setRoom("214");
        x.setFaculty("Garrett");
        x.setCapacity(15);
        x.setEnrolled(10);

        y.setTime(new TimeRange(new Time(10, 30), new Time(11, 30)));
        y.setDays("twR");

        z.setTime(new TimeRange(new Time(13, 30), new Time(14, 30)));
        z.setDays("MWF");
    }

    @AfterEach
    public void tearDown() {
        // Teardown code here (if required)
    }

    @Test
    public void testConstructor() {
        boolean init = x.getDepartment().equals("COSC") && x.getNumber().equals("235") && (x.getSection() == 1) &&
                    x.getDays().equals("MWF") && x.getTime().getStartTime().toString().equals("1100") &&
                    x.getTime().getEndTime().toString().equals("1230") && x.getBuilding().equals("OLIN") &&
                    x.getRoom().equals("214") && x.getFaculty().equals("Garrett") &&
                    (x.getCapacity() == 15) && (x.getEnrolled() == 10) &&
                    y.getDepartment().equals("COSC") && y.getNumber().equals("350") && (y.getSection() == 2) &&
                    y.getDays().equals("TWR") && y.getTime().getStartTime().toString().equals("1030") &&
                    y.getTime().getEndTime().toString().equals("1130") && y.getBuilding().equals("") &&
                    y.getRoom().equals("") && y.getFaculty().equals("") &&
                    (y.getCapacity() == 0) && (y.getEnrolled() == 0);
        assertTrue(init);
    }

    @Test
    public void testFull() {
        boolean full = !x.isFull();
        x.setEnrolled(x.getCapacity());
        full = full && x.isFull();
        x.setEnrolled(10);
        assertTrue(full);
    }

    @Test
    public void testMeets() {
        boolean meet = !x.meetsOn(Course.Day.SUN) && x.meetsOn(Course.Day.MON) && !x.meetsOn(Course.Day.TUE) && 
               x.meetsOn(Course.Day.WED) && !x.meetsOn(Course.Day.THU) && x.meetsOn(Course.Day.FRI) && !x.meetsOn(Course.Day.SAT);
        assertTrue(meet);
    }

    @Test
    public void testConflicts() {
        boolean conf = x.conflictsWith(y) && !x.conflictsWith(z);
        y.setDays("TR");
        conf = conf && !x.conflictsWith(y);
        assertTrue(conf);
    }

    @Test
    public void testString() {
        boolean string = x.toString().equals("COSC 235 1 MWF 1100 1230 OLIN 214 Garrett 15 10");
        assertTrue(string);
    }

}
