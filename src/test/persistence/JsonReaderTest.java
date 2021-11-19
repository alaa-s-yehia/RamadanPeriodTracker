package persistence;

import model.PeriodDay;
import model.PeriodTracker;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//cite: this class is modeled after the JsonReaderTest class from
//the JsonSterilizationDemo.Link:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

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
        JsonReader reader = new JsonReader("./data/testWriterEmptyPeriodTracker.json");
        try {
            PeriodTracker pt = reader.read();
            assertEquals("My Period Tracker",pt.getName());
            assertEquals(0, pt.numDays());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

//    @Test
//    void testReaderGeneralPeriodTracker() {
//        JsonReader reader = new JsonReader("./data/testWriterGeneralPeriodTracker.json");
//        try {
//            PeriodTracker pt = reader.read();
//            assertEquals("My Period Tracker", pt.getName());
//            List<PeriodDay> days = pt.getPeriod();
//            assertEquals(2, pt.numDays());
//            checkDay("alaa", false, true, "sad", days.get(0));
//            checkDay("alaa", false, false, "angry", days.get(1));
//        } catch (IOException e) {
//            fail("Couldn't read from file");
//        }
//    }
}
