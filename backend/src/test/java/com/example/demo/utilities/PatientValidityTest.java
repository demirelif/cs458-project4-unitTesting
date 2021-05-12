package com.example.demo.utilities;

import com.example.demo.patient.Patient;
import com.example.demo.patient.Patients;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Paths.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PatientValidityTest {

    @Mock
    PatientValidity patientValidity;

    @Test
    void checkPatientValidity() {
        JSONObject patientJSON = new JSONObject();
        patientJSON.put("name", "elif");
        patientJSON.put("age", 22);
        patientJSON.put("surname", "nn");
        patientJSON.put("email", "elifd@mail.com");
        patientJSON.put("password", "1234");
        patientJSON.put("gender", "f");
        patientJSON.put("gender", "f");
        Patient p = new Patient(patientJSON);
        patientValidity = new PatientValidity(p);
        patientValidity.checkPatientValidity();
        assert(true);
    }
}