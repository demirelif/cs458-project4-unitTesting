package com.example.demo.responses;
import com.fasterxml.jackson.databind.JsonNode;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.ResponseBody;

public class AuthResponse {
    boolean auth;
    String message;

    public AuthResponse(boolean auth, String message) {
        this.auth = auth;
        this.message = message;
    }

    public String asJSON() {
        JSONObject jso = new JSONObject();
        jso.put("auth", auth);
        jso.put("message", message);
        return jso.toJSONString();
    }

}
