package com.example.demo.patient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Patient implements JSONConvertable{
    int age;
    String name;
    String email;
    String password;
    String surname;
    String gender;
    List<DailySymptom> symptoms;

    public Patient(int age, String name, String email, String password, String surname, String gender, List<DailySymptom> symptoms) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.password = password;
        this.surname = surname;
        this.gender = gender;
        this.symptoms = symptoms;
    }

    public Patient(JSONObject patientJSON) {
        this.age = Integer.parseInt(patientJSON.get("age").toString());
        this.name = patientJSON.get("name").toString();
        this.surname = patientJSON.get("surname").toString();
        this.email = patientJSON.get("email").toString();
        this.password = patientJSON.get("password").toString();
        this.gender = patientJSON.get("gender").toString();
        this.symptoms = new ArrayList<>();
    }

    public boolean addSymptom(DailySymptom symptom){
        Optional<DailySymptom> alreadySymptom = symptoms.stream().filter(checkSymptom -> {
            return checkSymptom.date.equals(symptom.date);
        }).findAny();

        if (alreadySymptom.isPresent()) {
            alreadySymptom.get().replace(symptom);
        } else symptoms.add(symptom);

        return true;
    }

    public void removeSymptom(DailySymptom symptom){
        symptoms.remove(symptom);
    }

    public List<DailySymptom> getSymptoms() {
        return symptoms;
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
        jso.put("surname", surname);
        jso.put("gender", gender);
        jso.put("email", email);
        jso.put("password", password);
        JSONArray symptomsJSON = new JSONArray();
        symptoms.forEach(item -> {
            symptomsJSON.add(item.asJSON());
        });
        jso.put("symptoms", symptomsJSON);

        return jso;
    }

    public String getEmail() {
        return email;
    }

    public String checkDailyTrend() {
        if(symptoms.size() >= 2){
            return "Risky";
        }
        else{
            return "Well";
        }
    }
}
