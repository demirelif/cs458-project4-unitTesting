package com.example.demo.patient;

public enum Symptom {
    FEVER, COUGH;

    @Override
    public String toString() {
        switch (this) {
            case FEVER:
                return "Fever";
            case COUGH:
                return "Cough";
        }
        return "";
    }
}
