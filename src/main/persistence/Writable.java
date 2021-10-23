package persistence;

import org.json.JSONObject;

//Cited: from JsonSterilizationDemo
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
