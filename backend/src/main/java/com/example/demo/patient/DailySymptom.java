package com.example.demo.patient;

import org.json.simple.JSONObject;

import java.time.LocalDate;
import java.util.Date;

public class DailySymptom implements JSONConvertable {
    LocalDate date;
    Symptom symptom;

    public DailySymptom(LocalDate date, Symptom symptom) {
        this.date = date;
        this.symptom = symptom;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSymptom(Symptom symptom){
        this.symptom = symptom;
    }

    public String checkDailyTrend() {
        return "Well";
    }

    @Override
    public Object asJSON() {
        JSONObject jso = new JSONObject();
        jso.put("date", date.toString());
        jso.put("symptom", symptom.toString());
        return jso;
    }

}
