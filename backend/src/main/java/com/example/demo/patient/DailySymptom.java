package com.example.demo.patient;

import org.json.simple.JSONObject;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class DailySymptom implements JSONConvertable {

    String date;
    Set<Symptom> symptom;

    public DailySymptom(String date, Set<Symptom> symptom) {
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
