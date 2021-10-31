package persistence;

import model.PeriodDay;
import model.PeriodTracker;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

//cite: this class is modeled after the JsonReader class from
//the JsonSterilizationDemo.Link:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads periodTracker from file and returns it;
    // throws IOException if an error occurs reading data from file
    public PeriodTracker read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePeriodTracker(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses periodTracker from JSON object and returns it
    private PeriodTracker parsePeriodTracker(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        PeriodTracker pt = new PeriodTracker(name);
        addInfo(pt, jsonObject);
        return pt;
    }


    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to Period Tracker
    private void addInfo(PeriodTracker pt, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("days");
        for (Object json : jsonArray) {
            JSONObject nextDay = (JSONObject) json;
            addSingleDayInfo(pt, nextDay);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to PeriodTracker
    private void addSingleDayInfo(PeriodTracker pt, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Boolean period = jsonObject.getBoolean("period");
        Boolean fast = jsonObject.getBoolean("fast");
        String mood = jsonObject.getString("mood");
        PeriodDay day = new PeriodDay(period,fast,mood,name);
        pt.addDay(day);
    }

}
