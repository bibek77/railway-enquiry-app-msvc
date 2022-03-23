package com.github.bibek77.railwayenquiry.request.controller;

import com.github.bibek77.railwayenquiry.request.service.RailwayEnquiryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author bibek
 */
@Slf4j
@RestController
public class RailwayEnquiryController {

    @Autowired
    RailwayEnquiryService railwayEnquiryService;


    @GetMapping(ControllerURL.CUSTOM_HEALTH_CHECK_API)
    public ResponseEntity customHealthCheck() {

        HashMap<String, String> response = new HashMap<>();
        response.put("STATUS", "OK");
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(ControllerURL.PNR_RAILWAY_ENQUIRY_API)
    public ResponseEntity getPNRStatus(@PathVariable String pnr) {
        Object response = railwayEnquiryService.getPNRStatus(pnr);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
