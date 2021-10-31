package persistence;

import org.json.JSONObject;

//Cited: //cite: this class is modeled after the Writable interface from
//the JsonSterilizationDemo.Link:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
