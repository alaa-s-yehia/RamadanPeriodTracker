package persistence;

import com.sun.org.apache.xpath.internal.operations.Bool;
import model.PeriodDay;
import model.PeriodTracker;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PeriodTrackerReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public PeriodTrackerReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public PeriodTracker read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePeriodTracker(jsonObject);
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private PeriodTracker parsePeriodTracker(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        PeriodTracker pt = new PeriodTracker();
        addInfo(pt, jsonObject);
        return pt;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private PeriodTracker parseWorkRoom(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        PeriodTracker pt = new PeriodTracker();
        addInfo(pt, jsonObject);
        return pt;
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addInfo(PeriodTracker pt, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("thingies");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addSingleDayInfo(pt, nextThingy);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addSingleDayInfo(PeriodTracker pt, JSONObject jsonObject) {
        Boolean period = jsonObject.getBoolean("period");
        Boolean fast = Boolean.valueOf(jsonObject.getBoolean("fast"));
        String mood = jsonObject.getString("mood");
        PeriodDay day = new PeriodDay(period, fast,mood);
        pt.addPeriodDay(day);
    }


}
