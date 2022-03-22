package com.github.bibek77.railwayenquiry.request.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author bibek
 */
@Slf4j
@RestController
public class RailwayEnquiryController {

    @GetMapping("/api/health")
    public ResponseEntity customHealthCheck() {

        HashMap<String, String> response = new HashMap<>();
        response.put("STATUS", "OK");
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
