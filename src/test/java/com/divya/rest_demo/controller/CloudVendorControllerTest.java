package com.divya.rest_demo.controller;

import com.divya.rest_demo.model.CloudVendor;
import com.divya.rest_demo.service.CloudVendorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CloudVendorService cloudVendorService;

    CloudVendor cloudVendor1;
    CloudVendor cloudVendor2;
    List<CloudVendor> cloudVendorList = new ArrayList<CloudVendor>();

    @BeforeEach
    void setUp() {
        cloudVendor1 = new CloudVendor(1,"Amazon","USA","xxxxx");
        cloudVendor2 = new CloudVendor(2,"GCP","UK","yyyyy");
        cloudVendorList.add(cloudVendor1);
        cloudVendorList.add(cloudVendor2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_getCloudVendorDetails_success() throws Exception {
        when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendor1);
        this.mockMvc.perform(get("/cloudvendor/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void test_getAllCloudVendors_success() throws Exception {
        when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
        this.mockMvc.perform(get("/cloudvendor"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void test_createCloudVendorDetails_success() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(cloudVendor1);
        when(cloudVendorService.createCloudVendor(cloudVendor1)).thenReturn("Success");
        this.mockMvc.perform(post("/cloudvendor")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void test_updateCloudVendorDetails_success() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(cloudVendor1);
        when(cloudVendorService.updateCloudVendor(cloudVendor1)).thenReturn("Success");
        this.mockMvc.perform(put("/cloudvendor")
                        .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void test_deleteCloudVendorDetails_success() throws Exception {
        when(cloudVendorService.deleteCloudVendor("1")).thenReturn("Success");
        this.mockMvc.perform(delete("/cloudvendor/delete/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}