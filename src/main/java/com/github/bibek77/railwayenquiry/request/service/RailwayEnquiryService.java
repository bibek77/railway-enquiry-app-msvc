package com.github.bibek77.railwayenquiry.request.service;

import com.github.bibek77.railwayenquiry.request.controller.RestTemplateClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * @author bibek
 */
@Slf4j
@Service
public class RailwayEnquiryService {

    @Value("${pnr.status.enquiry.url}")
    private String pnr_enquiry_url;

    @Value("${pnr.status.api.key}")
    private String pnr_enquiry_apiKey;

    @Autowired
    RestTemplateClient restTemplate;

    public Object getPNRStatus(String pnr) {

        Object getPnrStatusResponse = new Object();
        try {
//            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("X-RapidAPI-Host", "pnr-status-indian-railway.p.rapidapi.com");
            httpHeaders.add("X-RapidAPI-Key", pnr_enquiry_apiKey);
            HttpEntity<String> request = new HttpEntity(null, httpHeaders);
            getPnrStatusResponse = restTemplate.restTemplate().exchange(pnr_enquiry_url, HttpMethod.GET, request, Object.class, pnr).getBody();
        } catch (Exception e) {
            log.error("Exception Generated while connecting to PNR Railway Rapid API : " + e.getMessage());
        }
        return getPnrStatusResponse;
    }
}
