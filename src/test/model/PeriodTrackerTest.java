package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PeriodTrackerTest {
    private PeriodTracker testPeriodTracker;

    @BeforeEach
   public void runBefore() {
        testPeriodTracker = new PeriodTracker(1,1,"happy");
    }

    @Test
    public void testConstructor() {
        assertEquals("happy",testPeriodTracker.getMood());
    }
    @Test
   public void testNoFast(){
        int initial = testPeriodTracker.getFast();
        int current = testPeriodTracker.fasting();
        assertEquals(1,initial-current);

    }



}