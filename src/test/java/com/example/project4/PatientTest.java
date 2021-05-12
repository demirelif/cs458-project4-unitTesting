package com.example.project4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    Patient patient;
    static ArrayList<Symptom> symptoms;

    @BeforeAll
    static void createSymptoms(){
        ArrayList<Symptom> symptoms = new ArrayList<>();
        Symptom symptom = new Symptom("Death", LocalDate.now(), 100.0);
        Symptom symptom2 = new Symptom("Fatigue", LocalDate.now(), 55.0);
        Symptom symptom3 = new Symptom("Fever", LocalDate.now(), 85.0);
        symptoms.add(symptom);
        symptoms.add(symptom2);
        symptoms.add(symptom3);
    }

    @BeforeEach
    void setup(){
        patient = new Patient("Atiba", "Canadian", 39);
    }

    @Test
    void getName() {
        assertEquals("Atiba", patient.getName());
    }

    @Test
    void setName() {
        patient.setName("Ghezzal");
        assertEquals("Ghezzal", patient.getName());
    }

    @Test
    void getDemographicInfo() {
        assertEquals("Canadian", patient.getDemographicInfo());
    }

    @Test
    void setDemographicInfo() {
        patient.setDemographicInfo("Brazilian");
        assertEquals("Brazilian", patient.getDemographicInfo());
    }

    @Test
    void getAge() {
        assertEquals(39, patient.getAge());
    }

    @Test
    void setAge() {
        patient.setAge(18);
        assertEquals(18, patient.getAge());
    }

    @Test
    void addSymptom(){

    }

    @Test
    void removeSymptom(){

    }

    @Test
    void getSymptoms() {
        setSymptoms();
        assertEquals(patient.getSymptoms(), symptoms);
    }

    @Test
    void setSymptoms() {
        patient.setSymptoms(symptoms);
    }
}