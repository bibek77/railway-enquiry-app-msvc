package com.github.bibek77.railwayenquiry.request.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author bibek
 */
@Service
public class RailwayEnquiryService {

    @Value("${pnr.status.enquiry.url}")
    private String pnr_enquiry_url;

    @Value("${pnr.status.api.key}")
    private String pnr_enquiry_apiKey;

//    RestTemplate restTemplate;
//
//    public RailwayEnquiryService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    public Object getPNRStatus(String pnr) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-RapidAPI-Host", "pnr-status-indian-railway.p.rapidapi.com");
        httpHeaders.add("X-RapidAPI-Key", pnr_enquiry_apiKey);
        HttpEntity<String> request = new HttpEntity(null,httpHeaders);
        Object getPnrStatusResponse = restTemplate.exchange(pnr_enquiry_url, HttpMethod.GET, request, Object.class, pnr).getBody();

        return  getPnrStatusResponse;
    }
}
