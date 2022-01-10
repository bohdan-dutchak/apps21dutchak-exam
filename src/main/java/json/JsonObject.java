package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    private List<JsonPair> objects;

    public JsonObject() {
        this.objects = new ArrayList<JsonPair>();
    }

    public JsonObject(JsonPair... jsonPairs) {
        this.objects = new ArrayList<JsonPair>(Arrays.asList(jsonPairs));
    }

    @Override
    public String toJson() {
        String result = "{";
        for (JsonPair jsp : this.objects) {
            result += "'" + jsp.key + "': " + jsp.value.toJson() + ", ";
        }
        if (!this.objects.isEmpty()) {
            result = result.substring(0, result.length() - 2);
        }
        result += "}";
        return result;
    }

    public void add(JsonPair jsonPair) {
        this.objects.add(jsonPair);
    }

    public Json find(String name) {
        for (JsonPair jsp : objects) {
            if (jsp.key.equals(name)) {
                return jsp.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        ArrayList<String> keys = new ArrayList<>(Arrays.asList(names));
        JsonObject result = new JsonObject();
        for (String key : keys) {
            for (JsonPair jsp : this.objects) {
                if (key.equals(jsp.key)) {
                    result.add(jsp);
                }
            }
        }
        return result;
    }

    public boolean contains(String name) {
        return this.projection(name).objects.size() != 0;
    }
}
