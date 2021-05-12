package com.example.demo.utilities;

import com.example.demo.patient.Patient;

import java.util.Arrays;
import java.util.List;

public class PatientValidity {
    Patient patient;

    public PatientValidity(Patient patient) {
        this.patient = patient;
    }

    public boolean checkPatientValidity() {
        return checkEmail();
    }

    public boolean checkEmail() {
        List<String> splittedByAt = Arrays.asList(patient.getEmail().split("@"));
        if (splittedByAt.size() != 2) {
            return false;
        } else if (splittedByAt.get(0).length() == 0 || splittedByAt.get(1).length() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
