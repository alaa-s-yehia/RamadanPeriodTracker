package persistence;

import model.PeriodDay;
import model.PeriodTracker;

import static org.junit.jupiter.api.Assertions.*;


public class JsonTest {
    protected void checkDay(String name, PeriodDay periodDay, PeriodTracker periodTracker) {
        assertEquals(name,periodDay.getName());
        assertEquals(periodDay,periodTracker.getFast());
        assertEquals(periodDay,periodTracker.getPeriod());
    }
}