package com.example.project4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SymptomTest {
    Symptom symptom;
    LocalDate date;

    @BeforeEach
    void setup(){
        date = LocalDate.now();
        symptom = new Symptom("Fever", date, 75.0 );
    }

    @Test
    void getName() {
        assertEquals("Fever", symptom.getName());
    }

    @Test
    void setName() {
        symptom.setName("Headache");
        assertEquals("Headache", symptom.getName());
    }

    @Test
    void getDate() {
        assertEquals(date, symptom.getDate());
    }

    @Test
    void setDate() {
        LocalDate mockdate = LocalDate.of(1991, 3, 12);
        Symptom symptom = new Symptom("Fever", date, 75.0 );
        symptom.setDate(mockdate);
        assertEquals(mockdate, symptom.getDate());
    }

    @Test
    void setRisk() {
        symptom.setRisk(13.0);
        assertEquals(13.0, symptom.getRisk());
    }

    @Test
    void getRisk() {
        assertEquals(75.0, symptom.getRisk());
    }
}