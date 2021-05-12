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
    String surname;
    String gender;
    List<DailySymptom> symptoms;

    public Patient(JSONObject patientJSON) {
        this.age = Integer.parseInt(patientJSON.get("age").toString());
        this.name = patientJSON.get("name").toString();
        this.surname = patientJSON.get("surname").toString();
        this.email = patientJSON.get("email").toString();
        this.password = patientJSON.get("password").toString();
        this.gender = patientJSON.get("gender").toString();
        this.symptoms = new ArrayList<>();
    }

    public void addSymptom(DailySymptom symptom){
        symptoms.add(symptom);
    }

    public void removeSymptom(DailySymptom symptom){
        symptoms.remove(symptom);
    }

    public List<DailySymptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<DailySymptom> symptoms) {
        this.symptoms = symptoms;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
