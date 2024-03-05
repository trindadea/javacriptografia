package com.example.Criptografia.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class Export {
    private String storedRequestBody = null;

    @PostMapping(value = "/export")
    public void setRequestBody(@RequestBody String requestBody) {
        storedRequestBody = requestBody;
    }

    @GetMapping("/export")
    public String exportAlpha() {
        if (storedRequestBody != null) {
            return storedRequestBody;
        } else {
            return "Nope";
        }
    }
}
