package com.example.demo.patient;

import com.example.demo.jsonhandling.JSONHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Patient implements JSONConvertable{
    int age;
    String name;
    String email;
    String password;
    List<DailySymptom> symptoms;

    public Patient(JSONObject patientJSON) {
        age = Integer.parseInt(patientJSON.get("age").toString());
        name = patientJSON.get("name").toString();
        email = patientJSON.get("email").toString();
        password = patientJSON.get("password").toString();
        symptoms = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Patient{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    @Override
    public JSONObject asJSON() {
        JSONObject jso = new JSONObject();
        jso.put("name", name);
        jso.put("age", age);
        jso.put("email", email);
        jso.put("password", password);
        JSONArray symptomsJSON = new JSONArray();
        symptoms.forEach(item -> {
            symptomsJSON.add(item.asJSON());
        });
        jso.put("symptoms", symptomsJSON);

        return jso;
    }
}
