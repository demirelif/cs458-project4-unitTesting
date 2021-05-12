package com.example.demo.jsonhandling;

import com.example.demo.patient.Patient;
import com.example.demo.patient.Patients;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class JSONHandler {

    public JSONHandler() {


    }

    public static void readDataJSON() {

        File dataFile = new File( "D:\\CS\\Current\\cs458-project4-unitTesting\\backend\\src\\main\\java\\com\\example\\demo\\jsonhandling\\data.json");

        JSONArray patientsJSON = parseArray(readFile(dataFile));
        patientsJSON.forEach(patientJSON -> {
            Patients.getInstance().patients.add(new Patient((JSONObject) patientJSON));
        });
    }

    public static String readFile(File file)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(file));)
        {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static JSONParser parser = new JSONParser();
    public static JSONObject parse(String text)
    {
        try
        {
            return (JSONObject) parser.parse(text);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONArray parseArray(String text)
    {
        try
        {
            return (JSONArray) parser.parse(text);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}