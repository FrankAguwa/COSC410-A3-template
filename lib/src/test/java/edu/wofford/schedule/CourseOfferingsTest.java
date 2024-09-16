
package edu.wofford.schedule;

import java.io.File;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseOfferingsTest {
    Course newCourse;
    CourseOfferings o;
    CourseOfferings orig;

    @BeforeEach
    public void setUp() throws UnsupportedEncodingException {
        newCourse = new Course("CS", "310", 1);
        o = new CourseOfferings(new File(URLDecoder.decode(getClass().getClassLoader().getResource("input.txt").getFile(), "UTF-8")));
        orig = new CourseOfferings(new File(URLDecoder.decode(getClass().getClassLoader().getResource("input.txt").getFile(), "UTF-8")));
    }

    @AfterEach
    public void tearDown() {
        // Teardown code here (if required)
    }

    @Test
    public void testSize() {
        boolean size = (o.getNumCourses() == 13);
        assertTrue(size);
    }

    @Test
    public void testGet() {
        Course c = o.getCourse(3);
        boolean gets = c.getNumber().equals("230") && (c.getSection() == 4) &&
                    c.getFaculty().equals("DaParma");
        boolean gexc = false;
        try { c = o.getCourse(13); } catch(ArrayIndexOutOfBoundsException e) { gexc = true; }
        assertTrue(gets && gexc);
    }

    @Test
    public void testSet() {
        o.setCourse(3, newCourse);
        Course c = o.getCourse(3);
        boolean sets = c.getNumber().equals("310");
        boolean sexc = false;
        try { o.setCourse(13, c); } catch(ArrayIndexOutOfBoundsException e) { sexc = true; }
        assertTrue(sets && sexc);
    }

    @Test
    public void testAdd() {
        boolean add = o.addCourse(newCourse);
        add = add && (o.getNumCourses() == 14) && o.getCourse(13).getNumber().equals("310");
        assertTrue(add);
    }

    @Test
    public void testString() {
        String expected = "CS 230 1 MWF 1015 1115 AH 257 DaParma 20 11\n" +
                        "CS 230 2 MWF 0845 0945 AH 257 Thornton 20 20\n" +
                        "CS 230 3 TR 1245 1415 AH 363 Ford 20 12\n" +
                        "CS 230 4 MWF 1230 1330 AH 361 DaParma 20 9\n" +
                        "CS 230 5 TR 1500 1629 AH 363 Garrett 20 16\n" +
                        "CS 231 1 TR 0915 1045 AH 363 Ford 20 11\n" +
                        "CS 231 2 TR 1245 1415 AH 257 Reaves 20 20\n" + 
                        "CS 232 1 MWF 1230 1330 AH 363 Jensen 15 14\n" +
                        "CS 232 2 MWF 1630 1800 AH 363 Garrett 15 5\n" +
                        "CS 310 1 TR 1430 1600 AH 259 Garrett 20 7\n" +
                        "CS 350 1 MWF 0845 0945 AH 336 Krishnaprasad 20 11\n" +
                        "CS 450 1 TR 0915 1045 AH 336 Francia 25 22\n" +
                        "CS 488 1 MWF 1345 1445 AH 336 Chao 25 20";
        boolean string = orig.toString().trim().equals(expected);
        assertTrue(string);
    }

}
