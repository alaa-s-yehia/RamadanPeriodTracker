package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PeriodTrackerTest {
    private PeriodTracker testPeriodTracker;

    @BeforeEach
    public void runBefore() {
        testPeriodTracker = new PeriodTracker();
    }

    @Test
    public void test1() {
        /*
         * Initialize records of vaccines recognized in Canada.
         * Input values of the constructor consist of the codename, type, and manufacturer.
         * No error handling is necessary for these input values.
         * See Section 2.3 of the lab manual for the list of recognized vaccines.
         */

        PeriodTracker t1 = new PeriodTracker();
        PeriodDay day1 = new PeriodDay(false,false,"happy");
        PeriodDay day2 = new PeriodDay(true,false,"sad");
        PeriodDay day3 = new PeriodDay(true,true,"angry");
        PeriodDay day4 = new PeriodDay(false,true,"happy");

        t1.addPeriodDay(day1);
        t1.addPeriodDay(day2);
        t1.addPeriodDay(day3);
        t1.addPeriodDay(day4);


        assertEquals(2, t1.getDaysLeftToFast());
        assertEquals(2, t1.getFast());
        assertEquals(2, t1.getPeriod());

        assertEquals(false, day1.getPeriod());
        assertEquals(false, day1.getFast());
        assertEquals("happy", day1.getMood());

        assertEquals(true, day2.getPeriod());
        assertEquals(false, day2.getFast());
        assertEquals("sad", day2.getMood());

        assertEquals(true, day3.getPeriod());
        assertEquals(true, day3.getFast());
        assertEquals("angry", day3.getMood());

        assertEquals(false, day4.getPeriod());
        assertEquals(true, day4.getFast());
        assertEquals("happy", day4.getMood());

    }


}