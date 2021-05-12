package com.example.demo;

import com.example.demo.jsonhandling.JSONHandler;
import com.example.demo.patient.Patient;
import com.example.demo.patient.Patients;
import com.example.demo.responses.AuthResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping(path = "api/patient")
public class ProjectApplication {

	public static void main(String[] args) {
		JSONHandler.readDataJSON();

		System.out.println(Patients.getInstance().toString());

		SpringApplication.run(ProjectApplication.class, args);
	}

	@GetMapping(path = "/login")
	@ResponseBody
	public String logIn(@RequestParam String email, String password) {
		Optional<Patient> patientOptional = Patients.getInstance().getPatient(email, password);
		if (patientOptional.isPresent()) {
			return new AuthResponse(true, "success").asJSON();
		} else {
			return new AuthResponse(false, "No User/Password match.").asJSON();
		}
	}

	@PostMapping(path= "/signup")
	public String registerNewPatient(@RequestBody String patientData) {
		boolean registered = Patients.getInstance().registerPatient( new Patient(Objects.requireNonNull(JSONHandler.parse(patientData))));
		return "{ \"signed\": " + "\"" + registered + "\""+ "}";

		// ToDO Save
	}

	@GetMapping("/all")
	public String getPatients() {
		return Patients.getInstance().asJSON();
	}



}
