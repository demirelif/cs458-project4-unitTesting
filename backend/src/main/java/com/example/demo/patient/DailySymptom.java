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

    @Override
    public Object asJSON() {
        JSONObject jso = new JSONObject();
        jso.put("date", date);
        JSONArray symptomsJSON = new JSONArray();
        symptomSet.forEach(symptom -> {
            symptomsJSON.add(symptom.toString());
        });
        jso.put("score", calculateScore());
        jso.put("symptoms", symptomsJSON);
        return jso;
    }

    public Set<Symptom> getSymptomSet(){
        return symptomSet;
    }

    public int calculateScore() {
        return symptomSet.stream().mapToInt(Symptom::getConditionScore).sum();
    }

    public void replace(DailySymptom symptom) {
        this.symptomSet = symptom.symptomSet;
    }
}
