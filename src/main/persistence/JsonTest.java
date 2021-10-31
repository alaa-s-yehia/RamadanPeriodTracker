package persistence;

import model.PeriodDay;
import model.PeriodTracker;

import static org.junit.jupiter.api.Assertions.*;


public class JsonTest {
    protected void checkDay(String period, String fasting, String mood,String name, PeriodDay periodDay) {
        assertEquals(name,periodDay.getName());
        assertEquals(period,periodDay.getPeriod());
        assertEquals(fasting,periodDay.getFast());
        assertEquals(mood,periodDay.getMood());
    }
}