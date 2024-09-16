package edu.wofford.app;

import edu.wofford.schedule.*;
import java.io.File;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    Student s;
    CourseOfferings o;

    @BeforeEach
    public void setUp() throws UnsupportedEncodingException {
        s = new Student();
        o = new CourseOfferings(new File(URLDecoder.decode(getClass().getClassLoader().getResource("input.txt").getFile(), "UTF-8")));
    }

    @AfterEach
    public void tearDown() {
        // Teardown code here (if required)
    }

    @Test
    public void testAdd() {
        boolean add = (s.addCourse(o.getCourse(2)) == Student.Result.SUCCESS) &&
              (s.addCourse(o.getCourse(0)) == Student.Result.DUPLICATE) &&
              (s.addCourse(o.getCourse(6)) == Student.Result.CONFLICT) &&
              (s.addCourse(o.getCourse(5)) == Student.Result.SUCCESS) &&
              (s.addCourse(o.getCourse(7)) == Student.Result.SUCCESS) &&
              (s.addCourse(o.getCourse(8)) == Student.Result.DUPLICATE) &&
              (s.addCourse(o.getCourse(9)) == Student.Result.SUCCESS) &&
              (s.addCourse(o.getCourse(10)) == Student.Result.SUCCESS) &&
              (s.addCourse(o.getCourse(11)) == Student.Result.OVERLOAD);
        assertTrue(add);
    }

    @Test
    public void testFull() {
        boolean full = (App.selectCourse(s, o, 6) == App.Result.FULL) && (o.getCourse(6).getEnrolled() == 20);
        assertTrue(full);
    }

    @Test
    public void testDupe() {
        boolean dupe = (App.selectCourse(s, o, 7) == App.Result.SUCCESS) &&
               (App.selectCourse(s, o, 8) == App.Result.DUPLICATE) && (o.getCourse(8).getEnrolled() == 5);
        assertTrue(dupe);
    }

    @Test
    public void testSucc() {
        boolean succ = (App.selectCourse(s, o, 10) == App.Result.SUCCESS) && (o.getCourse(10).getEnrolled() == 12);
        assertTrue(succ);
    }

    @Test
    public void testOver() {
        boolean over = (App.selectCourse(s, o, 2) == App.Result.SUCCESS) &&
               (App.selectCourse(s, o, 5) == App.Result.SUCCESS) &&
               (App.selectCourse(s, o, 7) == App.Result.SUCCESS) &&
               (App.selectCourse(s, o, 9) == App.Result.SUCCESS) &&
               (App.selectCourse(s, o, 10) == App.Result.SUCCESS) &&
               (App.selectCourse(s, o, 11) == App.Result.OVERLOAD) &&
               (o.getCourse(11).getEnrolled() == 22);
        assertTrue(over);
    }

    @Test
    public void testHigh() {
        boolean high = (App.selectCourse(s, o, 15) == App.Result.INVALID);
        assertTrue(high);
    }

    @Test
    public void testLow() {
        boolean low = (App.selectCourse(s, o, -1) == App.Result.INVALID);
        assertTrue(low);
    }
}
