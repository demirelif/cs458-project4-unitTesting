package com.example.demo.patient;

public enum Symptom {
    FEVER, COUGH, MUSCLEPAIN, NAUSEA, VOMITING, DIARRHEA;

    int getConditionScore() {
        switch (this) {

            case FEVER:
                return 2;
            case COUGH:
                return 1;
            case MUSCLEPAIN:
                return 1;
            case NAUSEA:
                return 2;
            case VOMITING:
                return 3;
            case DIARRHEA:
                return 3;
            default:
                throw new RuntimeException("Unknown Symptom");
        }
    }
}
