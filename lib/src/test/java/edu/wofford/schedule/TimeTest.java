
package edu.wofford.schedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    Time[] t;

    @BeforeEach
    public void setUp() {
        // Setup code here (if required)
        t = new Time[4];
        t[0] = new Time();
        t[1] = new Time("130");
        t[2] = new Time(14, 0);
        t[3] = new Time("1545");
    }

    @AfterEach
    public void tearDown() {
        // Teardown code here (if required)
    }

    @Test
    public void testConstructor() {
        boolean init = (t[0].getHour() == 0 && t[0].getMinute() == 0);
        init = init && (t[1].getHour() == 1 && t[1].getMinute() == 30);
        init = init && (t[2].getHour() == 14 && t[2].getMinute() == 0);
        init = init && (t[3].getHour() == 15 && t[3].getMinute() == 45);
        assertTrue(init);
    }

    @Test
    public void testBefore() {
        boolean before = t[0].before(t[1]) && t[1].before(t[2]) && t[2].before(t[3]);
        before = before && !(t[1].before(t[0])) && !(t[2].before(t[0])) && !(t[3].before(t[0]));
        before = before && !(t[2].before(t[1])) && !(t[3].before(t[1]));
        before = before && !(t[3].before(t[2]));
        assertTrue(before);
    }

    @Test
    public void testAfter() {
        boolean after = t[1].after(t[0]) && t[2].after(t[1]) && t[3].after(t[2]);
        after = after && !(t[0].after(t[1])) && !(t[0].after(t[2])) && !(t[0].after(t[3]));
        after = after && !(t[1].after(t[2])) && !(t[1].after(t[3]));
        after = after && !(t[2].after(t[3]));
        assertTrue(after);
    }

    @Test
    public void testEquals() {
        boolean equals = (t[0].equals(t[0])) && (t[1].equals(t[1])) && (t[2].equals(t[2])) && (t[3].equals(t[3]));
        equals = equals && !(t[0].equals(t[1])) && !(t[0].equals(t[2])) && !(t[0].equals(t[3]));
        equals = equals && !(t[1].equals(t[2])) && !(t[1].equals(t[3]));
        equals = equals && !(t[2].equals(t[3]));
        assertTrue(equals);
    }

    @Test
    public void testString() {
        boolean string = t[0].toString().equals("0000") && t[1].toString().equals("0130") &&
                        t[2].toString().equals("1400") && t[3].toString().equals("1545");
        assertTrue(string);
    }

}
