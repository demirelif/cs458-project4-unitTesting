package com.example.demo.patient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DailySymptomTest {

    String date = "2021-05-07";
    String date2 = "2021-08-12";
    String date3 = "2021-01-30";
    String date4 = "2021-02-13";
    @Test
    void replace() {
        DailySymptom ds = new DailySymptom(date, Set.of(Symptom.COUGH));
        DailySymptom ds2 = new DailySymptom(date2, Set.of(Symptom.MUSCLEPAIN));
        ds.replace(ds2);
        assertEquals(Set.of(Symptom.MUSCLEPAIN), ds.getSymptomSet());
    }

    @Test
    void calculateScore(){
        DailySymptom ds = new DailySymptom(date, Set.of(Symptom.COUGH));
        assertEquals(1, ds.calculateScore());
    }


}