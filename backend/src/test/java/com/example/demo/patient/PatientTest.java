package com.example.demo.patient;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    Patient p;
    static DailySymptom ds1;
    static DailySymptom ds2;
    static DailySymptom ds3;
    static DailySymptom ds4;
    String date = "2021-03-07";
    String date2 = "2021-02-07";
    String date3 = "2021-01-07";
    String date4 = "2021-05-07";
    @BeforeEach
    void setUp(){
        JSONObject patientJSON = new JSONObject();
        patientJSON.put("name", "elif");
        patientJSON.put("age", 22);
        patientJSON.put("surname", "nn");
        patientJSON.put("email", "elifd@mail.com");
        patientJSON.put("password", "1234");
        patientJSON.put("gender", "f");
        patientJSON.put("gender", "f");
        p = new Patient(patientJSON);
        ds1 = new DailySymptom(date, Set.of(Symptom.FEVER));
        ds2 = new DailySymptom(date2, Set.of(Symptom.COUGH));
        ds3 = new DailySymptom(date3, Set.of(Symptom.DIARRHEA));
        ds4 = new DailySymptom(date4, Set.of(Symptom.MUSCLEPAIN));
    }

    @Mock
    Patient patient;

    @Test
    void addSymptom() {
        p.addSymptom(ds1);
        p.addSymptom(ds2);
        p.addSymptom(ds3);
        assertEquals(3, p.getSymptoms().size());
    }

    @Test
    void removeSymptom() {
        p.addSymptom(ds1);
        p.addSymptom(ds2);
        p.addSymptom(ds3);
        p.removeSymptom(ds3);
        assertEquals(2, p.getSymptoms().size());
    }

    @Test
    void checkDailyTrend() {
        p.addSymptom(ds1);
        p.addSymptom(ds2);
        assertEquals("Risky", p.checkDailyTrend());
        JSONObject patientJSON = new JSONObject();
        patientJSON.put("name", "elif");
        patientJSON.put("age", 22);
        patientJSON.put("surname", "nn");
        patientJSON.put("email", "elifd@mail.com");
        patientJSON.put("password", "1234");
        patientJSON.put("gender", "f");
        patientJSON.put("gender", "f");
        patient = new Patient(patientJSON);
        Set<Symptom> symptoms = new HashSet<>();
        symptoms.add(Symptom.FEVER);
        symptoms.add(Symptom.NAUSEA);
        patient.addSymptom(new DailySymptom("03.04.2021", symptoms));
        assertEquals(true,true);
    }
}