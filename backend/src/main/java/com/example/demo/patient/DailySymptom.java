package com.example.demo.patient;

import org.json.simple.JSONObject;

import java.util.Date;

public class DailySymptom implements JSONConvertable {
    Date date;
    Symptom symptom;

    public DailySymptom(Date date, Symptom symptom) {
        this.date = date;
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
