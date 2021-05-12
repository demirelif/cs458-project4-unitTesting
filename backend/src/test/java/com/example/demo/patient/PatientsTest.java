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
        List<DailySymptom> symptoms;
        symptoms = new ArrayList<>();
        DailySymptom ds = new DailySymptom("04.09.2021", Set.of(Symptom.FEVER));
        symptoms.add(ds);
        JSONObject patientJSON = new JSONObject();
        patientJSON.put("name", "alsgai");
        patientJSON.put("age", 5);
        patientJSON.put("surname", "ali");
        patientJSON.put("email", "curaartun@gmail.com");
        patientJSON.put("password", "11");
        patientJSON.put("gender", "male");
        Patient p = new Patient(patientJSON);
        patients = new Patients();
        patients.registerPatient(p);
        patients.getPatient("curaartun@gmail.com");
        assertEquals(p, patients.getPatient("curaartun@gmail.com").get());
        //patients.getPatient("utku@mail.com", "123");
        assertEquals(p, patients.getPatient("curaartun@gmail.com", "11").get());
    }

    @Test
    void registerPatient() {
        List<DailySymptom> symptoms;
        symptoms = new ArrayList<>();
        //DailySymptom ds = new DailySymptom("04.09.2020", Set.of(Symptom.FEVER));
        DailySymptom ds = new DailySymptom("2021-03-07", Set.of(Symptom.FEVER));
        symptoms.add(ds);
        JSONObject patientJSON = new JSONObject();
        patientJSON.put("name", "elif");
        patientJSON.put("age", 22);
        patientJSON.put("surname", "nn");
        patientJSON.put("email", "elifd@mail.com");
        patientJSON.put("password", "1234");
        patientJSON.put("gender", "f");
        Patient p = new Patient(patientJSON);
        patients = new Patients();
        //patients.registerPatient(p);
        assertEquals(true, patients.registerPatient(p));
    }

    @Test
    void isEmailTaken() {
        patients = new Patients();
      //  patients.isEmailTaken("elifd@mail.com");
        assertEquals(false, patients.isEmailTaken("elifd@mail.com"));
    }
}