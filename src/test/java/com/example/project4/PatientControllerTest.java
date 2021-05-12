package com.example.project4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PatientController.class)
class PatientControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getInstance() {
        assertEquals(true, PatientController.getInstance() instanceof PatientController);
    }

    @Test
    void isUsernameTaken() {
        PatientController controller = PatientController.getInstance();
        controller.registerUser("UTKU", "12345");
        assertEquals(false, controller.isUsernameTaken("utku"));
        // assertEquals(true, controller.isUsernameTaken("atiba")); will fail
    }

    @Test
    void registerUser() {
        RequestBuilder request = MockMvcRequestBuilders.get("/register").param("username", "UTKU").param("password", "12345");
        try {
            MvcResult result = mvc.perform(request).andReturn();
            assertEquals("true", result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void isLoginCorrect() {
        RequestBuilder request = MockMvcRequestBuilders.get("/login").param("username", "UTKU").param("password", "12345");
        try {
            MvcResult result = mvc.perform(request).andReturn();
            assertEquals("true", result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}