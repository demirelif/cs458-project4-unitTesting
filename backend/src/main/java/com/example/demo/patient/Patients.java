package com.example.demo.patient;

import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Patients implements JSONConvertable {
    static Patients instance;
    public List<Patient> patients;

    private Patients() {
        patients = new ArrayList<>();
    }

    public static Patients getInstance() {
        if (instance == null) {
            instance = new Patients();
        }
        return instance;
    }

    public Optional<Patient> getPatient(String email, String password) {
        return patients.stream().filter(e-> e.email.equals(email) && e.password.equals(password)).findFirst();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patients=" + patients +
                '}';
    }

    @Override
    public String  asJSON() {
        JSONArray jsa = new JSONArray();
        patients.forEach(item -> {
            jsa.add(item.asJSON());
        });
        return jsa.toString();
    }
}
