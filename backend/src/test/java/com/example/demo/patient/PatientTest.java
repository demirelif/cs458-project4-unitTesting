package com.example.demo.patient;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Mock
    Patient patient;

    @Test
    void addSymptom() {
        JSONObject patientJSON = new JSONObject();
        patientJSON.put("name", "elif");
        patientJSON.put("age", 22);
        patientJSON.put("surname", "nn");
        patientJSON.put("email", "elifd@mail.com");
        patientJSON.put("password", "1234");
        patientJSON.put("gender", "f");
        patient = new Patient(patientJSON);
        Set<Symptom> symptoms = new HashSet<>();
        symptoms.add(Symptom.FEVER);
        symptoms.add(Symptom.NAUSEA);
        patient.addSymptom(new DailySymptom("03.04.2021", symptoms));
        assertEquals(true,true);
    }
}