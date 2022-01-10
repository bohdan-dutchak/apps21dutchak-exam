package domain;

import json.Jsonable;
import json.JsonPair;
import json.JsonNumber;
import json.JsonObject;
import json.JsonString;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    protected String name;
    protected String surname;
    protected Integer year;

    public BasicStudent() {
    }

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject result = new JsonObject(
                new JsonPair("name", new JsonString(this.name)),
                new JsonPair("surname", new JsonString(this.surname)),
                new JsonPair("year", new JsonNumber(this.year))
        );
        return result;
    }
}
