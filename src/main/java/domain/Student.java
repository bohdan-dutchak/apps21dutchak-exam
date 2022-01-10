package domain;

import json.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {

    private List<Tuple<String, Integer>> exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = Arrays.asList(exams);
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject[] jsonObjects = new JsonObject[this.exams.size()];
        for (int i = 0; i < this.exams.size(); i++){
            jsonObjects[i] = new JsonObject(
                    new JsonPair("course", new JsonString(this.exams.get(i).key)),
                    new JsonPair("mark", new JsonNumber(this.exams.get(i).value)),
                    new JsonPair("passed", new JsonBoolean(didPass(this.exams.get(i).value)))
            );
        }

        return new JsonObject(new JsonPair("name", new JsonString(this.name)),
                new JsonPair("surname", new JsonString(this.surname)),
                new JsonPair("year", new JsonNumber(this.year)),
                new JsonPair("exams", new JsonArray(jsonObjects)));
    }

    boolean didPass(Integer mark){
        return mark>2;
    }
}