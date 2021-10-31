package persistence;

import model.PeriodDay;

import static org.junit.jupiter.api.Assertions.*;

//cite: this class is modeled after the JsonTest class from
//the JsonSterilizationDemo.Link:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonTest {
    protected void checkDay(String name,Boolean period,Boolean fast,String mood, PeriodDay periodDay) {
        assertEquals(name,periodDay.getName());
        assertEquals(period, periodDay.getPeriod());
        assertEquals(fast,periodDay.getFast());
        assertEquals(mood,periodDay.getMood());
    }
}