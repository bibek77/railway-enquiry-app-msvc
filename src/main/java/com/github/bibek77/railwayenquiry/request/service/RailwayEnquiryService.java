package com.github.bibek77.railwayenquiry.request.service;

import com.github.bibek77.railwayenquiry.request.controller.RestTemplateClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bibek
 */
@Slf4j
@Service
public class RailwayEnquiryService {

    @Value("${pnr.status.enquiry.url}")
    private String pnr_enquiry_url;

    @Value("${train.details.enquiry.url}")
    private String train_details_enquiry_url;

    @Value("${rapid.api.application.key}")
    private String rapidApiKey;

    @Autowired
    RestTemplateClient restTemplate;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Object getPNRStatus(String pnr) {

        Object getPnrStatusResponse = new Object();
        try {
//            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("X-RapidAPI-Host", "pnr-status-indian-railway.p.rapidapi.com");
            httpHeaders.add("X-RapidAPI-Key", rapidApiKey);
            HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
            getPnrStatusResponse = restTemplate.restTemplate().exchange(pnr_enquiry_url, HttpMethod.GET, request, Object.class, pnr).getBody();

            Map<String, String> pnrResponseMap = (Map<String, String>) getPnrStatusResponse;

            if (pnrResponseMap != null && pnrResponseMap.containsKey("error")) {
                log.error("Pnr does not exists in the Railway System : " + pnr);
            }
        } catch (Exception e) {
            log.error("Exception Generated while connecting to PNR Railway Rapid API : " + e.getMessage());
        }
        return getPnrStatusResponse;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Object getTrainDetails(String train) {

        Object trainDetailsResponse = new Object();
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("X-RapidAPI-Host", "trains.p.rapidapi.com");
            httpHeaders.add("X-RapidAPI-Key", rapidApiKey);
            httpHeaders.add("content-type", "application/json");
            Map<String, String> searchRequestBody = new HashMap<>();
            searchRequestBody.put("search", train);
            HttpEntity<Map<String, String>> request = new HttpEntity<>(searchRequestBody, httpHeaders);
            trainDetailsResponse = restTemplate.restTemplate().exchange(train_details_enquiry_url, HttpMethod.POST, request, Object.class).getBody();

            List<Map> trainDetailsResponseMap = (List<Map>) trainDetailsResponse;

            if (trainDetailsResponseMap != null && trainDetailsResponseMap.size() == 0) {
                log.error("Train Details does not exists in the Railway System : " + train);
            }
        } catch (Exception e) {
            log.error("Exception Generated while connecting to Train Details Railway Rapid API : " + e.getMessage());
        }
        return trainDetailsResponse;
    }
}
