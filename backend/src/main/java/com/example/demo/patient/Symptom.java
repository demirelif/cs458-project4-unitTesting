package com.example.demo.patient;

public enum Symptom {
    FEVER, COUGH;

    @Override
    public String toString() {
        return switch (this) {
            case FEVER -> "Fever";
            case COUGH -> "Cough";
        };
    }
}
