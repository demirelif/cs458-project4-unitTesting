package com.example.demo.patient;

import com.example.demo.utilities.PatientValidity;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Patients implements JSONConvertable {
    static Patients instance;
    public List<Patient> patients;

    public Patients() {
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

    public Optional<Patient> getPatient(String email) {
        return patients.stream().filter(e-> e.email.equals(email)).findFirst();
    }

    public boolean registerPatient(Patient patient) {
        if (isEmailTaken(patient.getEmail())) {
            return false;
        }

        if (new PatientValidity(patient).checkPatientValidity()) {
            patients.add(patient);
            return true;
        }
        return false;
    }

    public boolean isEmailTaken(String email){
        Optional<Patient> p = patients.stream().filter(e-> e.email.equals(email)).findFirst();
        if(p.isPresent()){
            if(! p.get().email.equals("")){
                return true;
            }
        }
        return false;
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
