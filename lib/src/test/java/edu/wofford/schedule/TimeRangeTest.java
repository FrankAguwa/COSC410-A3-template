
package edu.wofford.schedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeRangeTest {
    TimeRange r1000to1130;
    TimeRange r1100to1400;
    TimeRange r1400to1500;

    @BeforeEach
    public void setUp() {
        // Setup code here (if required)
        r1000to1130 = new TimeRange(new Time(11, 30), new Time(10, 0));
        r1100to1400 = new TimeRange(new Time(11, 0), new Time(14, 0));
        r1400to1500 = new TimeRange(new Time(14, 0), new Time(15, 0));
    }

    @AfterEach
    public void tearDown() {
        // Teardown code here (if required)
    }

    @Test
    public void testConstructor() {
        boolean init = r1000to1130.getStartTime().toString().equals("1000") &&
               r1000to1130.getEndTime().toString().equals("1130") &&
               r1100to1400.getStartTime().toString().equals("1100") &&
               r1100to1400.getEndTime().toString().equals("1400") &&
               r1400to1500.getStartTime().toString().equals("1400") &&
               r1400to1500.getEndTime().toString().equals("1500");
        assertTrue(init);
    }

    @Test
    public void testDuration() {
        boolean dura = (r1000to1130.getDuration() == 90) &&
                    (r1100to1400.getDuration() == 180) &&
                    (r1400to1500.getDuration() == 60);
        assertTrue(dura);
    }

    @Test
    public void testContains() {
        boolean cont = r1000to1130.contains(new Time(11, 0)) &&
                    r1000to1130.contains(new Time(10, 0)) &&
                    r1000to1130.contains(new Time(11, 30)) &&
                    !r1000to1130.contains(new Time(9, 59)) &&
                    !r1000to1130.contains(new Time(11, 31));
        assertTrue(cont);
    }

    @Test
    public void testOverlaps() {
        boolean over = r1000to1130.overlaps(r1100to1400) && 
               r1100to1400.overlaps(r1400to1500) &&
               !r1000to1130.overlaps(r1400to1500);
        assertTrue(over);
    }

    @Test
    public void testString() {
        boolean string = r1000to1130.toString().equals("1000-1130") &&
                 r1100to1400.toString().equals("1100-1400") &&
                 r1400to1500.toString().equals("1400-1500");
        assertTrue(string);
    }


}
