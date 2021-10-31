package model;

import model.PeriodDay;
import model.PeriodTracker;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            PeriodTracker pt = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyPeriodTracker() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPeriodTracker.json");
        try {
            PeriodTracker pt = reader.read();
            assertEquals("My Period Tracker", pt.getName());
            assertEquals(0, pt.numDays());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralPeriodTracker() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPeriodTracker.json");
        try {
            PeriodTracker pt = reader.read();
            assertEquals("My Period Tracker", pt.getName());
            List<PeriodDay> days = pt.getPeriod();
            assertEquals(2, days.size());
//            checkDay("alaa",P);
//            checkDay();
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
