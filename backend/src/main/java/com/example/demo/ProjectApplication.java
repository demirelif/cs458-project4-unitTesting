package com.example.demo;

import com.example.demo.jsonhandling.JSONHandler;
import com.example.demo.patient.Patient;
import com.example.demo.patient.Patients;
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

	// Will Be Useful
	// LocalDate.of(2000, Month.JANUARY, 5);
	@GetMapping
	@ResponseBody
	public String getPatient(@RequestParam String email, String password) {
		Optional<Patient> patientOptional = Patients.getInstance().getPatient(email, password);
		if (patientOptional.isPresent()) {
			return patientOptional.get().asJSON().toString();
		} else {
			return "NOT FOUND";
		}
	}

	@GetMapping("/all")
	public String getPatients() {
		return Patients.getInstance().asJSON();
	}

	@PostMapping
	public void registerNewPatient(@RequestBody String patientData) {
		Patients.getInstance().addPatient( new Patient(Objects.requireNonNull(JSONHandler.parse(patientData))));
		// SAVE FILE
	}

}
