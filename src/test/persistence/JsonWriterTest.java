package persistence;

import model.PeriodTracker;
import model.PeriodDay;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//cite: this class is modeled after the JsonWriterTest class from
//the JsonSterilizationDemo.Link:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFile() {
        try {
            PeriodTracker pt = new PeriodTracker("My period tracker");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyPeriodTracker() {
        try {
            PeriodTracker pt = new PeriodTracker("My Period Tracker");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPeriodTracker.json");
            writer.open();
            writer.write(pt);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPeriodTracker.json");
            pt = reader.read();
            assertEquals("My Period Tracker", pt.getName());
            assertEquals(0, pt.numDays());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralPeriodTracker() {
        try {
            PeriodTracker pt = new PeriodTracker("My Period Tracker");
            pt.addDay(new PeriodDay(false, true, "sad", "alaa"));
            pt.addDay(new PeriodDay(false, false, "angry", "alaa"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPeriodTracker.json");
            writer.open();
            writer.write(pt);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPeriodTracker.json");
            pt = reader.read();
            assertEquals("My Period Tracker", pt.getName());
            List<PeriodDay> days = pt.getPeriod();
            assertEquals(2, days.size());
            PeriodDay p = days.get(0);
            checkDay("alaa", false, true, "sad", days.get(0));
            p = days.get(1);
            checkDay("alaa", false, false, "angry", days.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
