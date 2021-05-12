package com.example.demo.patient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Set;

public class DailySymptom implements JSONConvertable {

    String date;
    Set<Symptom> symptomSet;

    public DailySymptom(String date, Set<Symptom> symptomSet) {
        this.date = date;
        this.symptomSet = symptomSet;
    }

    public String checkDailyTrend() {
        return "Well";
    }

    @Override
    public Object asJSON() {
        JSONObject jso = new JSONObject();
        jso.put("date", date);
        JSONArray symptomsJSON = new JSONArray();
        symptomSet.forEach(symptom -> {
            symptomsJSON.add(symptom.toString());
        });

        jso.put("symptom", symptomsJSON);
        return jso;
    }

    public void merge(DailySymptom symptom) {
        this.symptomSet.addAll(symptom.symptomSet);
    }
}
