package com.example.demo.patient;

import com.example.demo.jsonhandling.JSONHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(Patients.class)
class PatientsTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void getInstance() {
        assertNotNull(Patients.getInstance());
    }

    @Test
    void getPatient() {

    }

    @Test
    void registerPatient() {
        List<DailySymptom> symptoms;
        symptoms = new ArrayList<>();
        DailySymptom ds = new DailySymptom(LocalDate.now(), Symptom.FEVER);
        symptoms.add(ds);
        Patient p = new Patient(13, "utku", "utku@email.com", "1234", "rocker", "male", symptoms);
        //RequestBuilder request = MockMvcRequestBuilders.get("/registerPatient").param("patient", p);

    }

    @Test
    void isEmailTaken() {
        RequestBuilder request = MockMvcRequestBuilders.get("/isTaken").param("email", "utku@gmail.com");
        try {
            MvcResult result = mvc.perform(request).andReturn();
            System.out.println(result.getResponse().getContentAsString());
            assertEquals("false", result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void isLoginCorrect() {
    }
}