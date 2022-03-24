package com.github.bibek77.railwayenquiry.request.controller;

import com.github.bibek77.railwayenquiry.request.service.RailwayEnquiryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<HashMap<String, String>> customHealthCheck() {

        HashMap<String, String> response = new HashMap<>();
        response.put("STATUS", "OK");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(ControllerURL.PNR_RAILWAY_ENQUIRY_API)
    public ResponseEntity<Object> getPNRStatus(@PathVariable String pnr) {
        Object response = railwayEnquiryService.getPNRStatus(pnr);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping(ControllerURL.GET_TRAIN_DETAILS)
    public ResponseEntity<Object> getTrainDetails(@RequestParam(required = true) String train) {
        Object response = railwayEnquiryService.getTrainDetails(train);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
