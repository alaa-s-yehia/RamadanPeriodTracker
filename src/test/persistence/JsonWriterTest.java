package persistence;

import model.PeriodTracker;
import model.PeriodDay;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonTest;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(pt);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
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
            pt.addPeriodDay(new PeriodDay(false,true,"sad","alaa"));
            pt.addPeriodDay(new PeriodDay(false,false,"angry","alaa"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPeriodTracker.json");
            writer.open();
            writer.write(pt);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPeriodTracker.json");
            pt = reader.read();
            assertEquals("My Period Tracker", pt.getName());
            List<PeriodDay> days = pt.getPeriod();
            assertEquals(3, days.size());
//            checkDay("alaa",days.get(2));
//            checkDay("alaa",days.get(3));


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
