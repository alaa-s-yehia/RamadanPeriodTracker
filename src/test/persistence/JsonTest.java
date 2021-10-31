package persistence;

import model.PeriodDay;

import static org.junit.jupiter.api.Assertions.*;


public class JsonTest {
    protected void checkDay(String name,Boolean period,Boolean fast,String mood, PeriodDay periodDay) {
        assertEquals(name,periodDay.getName());
        assertEquals(period, periodDay.getPeriod());
        assertEquals(fast,periodDay.getFast());
        assertEquals(mood,periodDay.getMood());
    }
}