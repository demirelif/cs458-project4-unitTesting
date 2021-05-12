package com.example.project4;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PatientController {

    private static PatientController instance = new PatientController();

    /**
     * Map of usernames to their passwords.
     */
    private Map<String, String> userMap = new HashMap<>();

    public static PatientController getInstance(){
        return instance;
    }

    // This class is a singleton. Call getInstance() instead.

    private PatientController(){}

    @RequestMapping("/")
    public @ResponseBody
    String greeting() {
        return "Hello, PatientController";
    }

    @GetMapping("/isTaken")
    public boolean isUsernameTaken(@RequestParam("username") String username){
        return userMap.containsKey(username);
    }

    @GetMapping("/register")
    public boolean registerUser(@RequestParam("username") String username, @RequestParam("password") String password){
        if(isUsernameTaken(username)){
            return false;
        }
        else{
            userMap.put(username, password);
            return true;
        }
    }

    @GetMapping("/login")
    public boolean isLoginCorrect(@RequestParam("username") String username, @RequestParam("password") String password) {
        // username isn't registered
        if(!userMap.containsKey(username)){
            return false;
        }

        String storedPassword = userMap.get(username);

        return password.equals(storedPassword);
    }

}
