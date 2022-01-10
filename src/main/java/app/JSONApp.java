package app;

import domain.BasicStudent;
import json.Json;
import json.JsonPair;
import json.JsonNumber;
import json.JsonArray;
import json.JsonObject;
import json.JsonString;
import json.JsonBoolean;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        final int magicTwo = 2, magicThree = 3, magicFour = 4;
        Json jYear = new JsonNumber(magicTwo);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(magicThree), new JsonNumber(magicFour));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj);

        print(jsonObj.projection("surname", "age", "year", "marks"));

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject());

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

    public static JsonObject sessionResult() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(new JsonPair("name", new JsonString("Andrii")));
        jsonObject.add(new JsonPair("surname", new JsonString("Rodionov")));
        jsonObject.add(new JsonPair("year", new JsonNumber(2)));
        JsonArray jsna = new JsonArray(
                new JsonObject(
                        new JsonPair("course", new JsonString("OOP")),
                        new JsonPair("mark", new JsonNumber(3)),
                        new JsonPair("passed", new JsonBoolean(true))),
                new JsonObject(
                        new JsonPair("course", new JsonString("English")),
                        new JsonPair("mark", new JsonNumber(5)),
                        new JsonPair("passed", new JsonBoolean(true))),
                new JsonObject(
                        new JsonPair("course", new JsonString("Math")),
                        new JsonPair("mark", new JsonNumber(2)),
                        new JsonPair("passed", new JsonBoolean(false)))
        );
        jsonObject.add(new JsonPair("exams", jsna));
        return jsonObject;
    }
}
