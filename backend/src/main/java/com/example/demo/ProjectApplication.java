package com.example.demo;

import com.example.demo.jsonhandling.JSONHandler;
import com.example.demo.patient.DailySymptom;
import com.example.demo.patient.Patient;
import com.example.demo.patient.Patients;
import com.example.demo.patient.Symptom;
import com.example.demo.responses.AuthResponse;
import com.fasterxml.jackson.databind.JsonNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
@RequestMapping(path = "api/patient")
@CrossOrigin(origins = "*")
public class ProjectApplication {

	public static void main(String[] args) {
		JSONHandler.readDataJSON();
		System.out.println(LocalDate.of(1999, Month.SEPTEMBER, 7).toString());

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

	@GetMapping(path= "/symptoms")
	@ResponseBody
	public String getSymptoms(@RequestParam String email) {
		Optional<Patient> patientOptional = Patients.getInstance().getPatient(email);

		if(patientOptional.isPresent()) {
			JSONArray jsa = new JSONArray();
			patientOptional.get().getSymptoms().forEach(sypmtom -> {
				jsa.add(sypmtom.asJSON());
			});

			return jsa.toString();

		} else {
			throw new IllegalStateException("User Does Not Exist");
		}
	}

	@PostMapping(path= "/sendsymptoms")
	public String addSymptoms(@RequestBody String symptomData) {
		JSONObject allData = Objects.requireNonNull(JSONHandler.parse(symptomData));
		Optional<Patient> patientOptional = Patients.getInstance().getPatient(allData.get("authed_email").toString());

		if (patientOptional.isPresent()) {
			JSONArray sypmtomsJSON = (JSONArray) allData.get("symptoms");

			Set<Symptom> symptoms = new HashSet<>();
			sypmtomsJSON.forEach(symptomJSON -> {
					String symptomString = (String) symptomJSON;
					symptoms.add(Symptom.valueOf(symptomString));
			});

			boolean added = patientOptional.get().addSymptom( new DailySymptom(allData.get("date").toString(),symptoms));
			return "{ \"added\": " + "\"" + added + "\""+ "}";
		} else {
			return "{ \"added\": " + "\"" + "false" + "\""+ "}";
		}
		// ToDO Save
	}

	@GetMapping("/all")
	public String getPatients() {
		return Patients.getInstance().asJSON();
	}

}