package persistence;

import model.PeriodDay;
import static org.junit.jupiter.api.Assertions.*;


public class JsonTest {
    protected void checkDay(String name, PeriodDay periodDay) {
        assertEquals(name,periodDay.getName());
        assertEquals(periodDay,periodDay.getPeriod());
    }
}