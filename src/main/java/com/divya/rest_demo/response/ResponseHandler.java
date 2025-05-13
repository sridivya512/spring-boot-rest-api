package com.divya.rest_demo.response;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String message,
                                                         HttpStatus httpStatus, Object responseObject) {

        Map<String,Object> responseMap = new LinkedHashMap<>();
        responseMap.put("message", message);
        responseMap.put("httpStatus",httpStatus);

        // Adding record count wherever applicable
        if (responseObject instanceof List<?>) {
            responseMap.put("recordCount", ((List<?>) responseObject).size());
        } else if (responseObject instanceof Page<?>) {
            responseMap.put("recordCount", ((Page<?>) responseObject).getSize());
        }
        responseMap.put("data", responseObject);

        return new ResponseEntity<>(responseMap, httpStatus);
    }

}
