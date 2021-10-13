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
   public void testNoFast(){
        int initial = testPeriodTracker.getFast();
        int current = testPeriodTracker.fasting();
        assertEquals(0,initial-current);

    }



}