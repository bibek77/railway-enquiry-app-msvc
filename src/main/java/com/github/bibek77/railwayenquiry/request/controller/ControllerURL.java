package com.github.bibek77.railwayenquiry.request.controller;

/**
 * @author bibek
 */
public interface ControllerURL {

    String CUSTOM_HEALTH_CHECK_API = "/v1.0/rail-api/health";
    String PNR_RAILWAY_ENQUIRY_API = "/v1.0/rail-api/pnr/{pnr}";
    String GET_TRAIN_DETAILS = "/v1.0/rail-api/train/details";
}
