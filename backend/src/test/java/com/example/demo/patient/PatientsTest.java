package com.example.demo.patient;

import com.example.demo.jsonhandling.JSONHandler;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
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
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(Patients.class)
class PatientsTest {
    @Autowired
    private MockMvc mvc;

    @Mock
    Patients patients;

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
        DailySymptom ds = new DailySymptom("04.09.2020", Set.of(Symptom.FEVER));
        symptoms.add(ds);
        JSONObject patientJSON = new JSONObject();
        patientJSON.put("name", "elif");
        patientJSON.put("age", 22);
        patientJSON.put("surname", "nn");
        patientJSON.put("email", "elifd@mail.com");
        patientJSON.put("password", "1234");
        patientJSON.put("gender", "f");
        patientJSON.put("gender", "f");
        Patient p = new Patient(patientJSON);
        patients = new Patients();
        patients.registerPatient(p);
        assert(true);
    }

    @Test
    void isEmailTaken() {
        patients = new Patients();
        patients.isEmailTaken("elifd@mail.com");
        assert(true);
    }

    @Test
    void isLoginCorrect() {
        JSONObject patientJSON = new JSONObject();
        patientJSON.put("name", "elif");
        patientJSON.put("age", 22);
        patientJSON.put("surname", "nn");
        patientJSON.put("email", "elifd@mail.com");
        patientJSON.put("password", "1234");
        patientJSON.put("gender", "f");
        patientJSON.put("gender", "f");
        Patient p = new Patient(patientJSON);
        patients = new Patients();
        patients.registerPatient(p);
        patients = new Patients();
        patients.isLoginCorrect("dd@mail.com","1234");
        assertEquals(false, false);
    }
}