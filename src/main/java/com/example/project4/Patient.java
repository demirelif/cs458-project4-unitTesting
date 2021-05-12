package com.example.project4;

import java.util.ArrayList;

public class Patient {
    String name;
    String demographicInfo;
    Integer age;
    ArrayList<Symptom> symptoms;

    public Patient(String name, String demographicInfo, Integer age){
        this.name = name;
        this.demographicInfo = demographicInfo;
        this.age = age;
        this.symptoms = new ArrayList<>();
    }

    public void addSymptom(Symptom symptom){
        symptoms.add(symptom);
    }

    public void removeSymptom(Symptom symptom){
        symptoms.remove(symptom);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDemographicInfo() {
        return demographicInfo;
    }

    public void setDemographicInfo(String demographicInfo) {
        this.demographicInfo = demographicInfo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ArrayList<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(ArrayList<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", demographicInfo='" + demographicInfo + '\'' +
                ", age=" + age +
                ", symptoms=" + symptoms +
                '}';
    }
}
