package com.divya.rest_demo.controller;

import com.divya.rest_demo.model.CloudVendor;
import com.divya.rest_demo.response.ResponseHandler;
import com.divya.rest_demo.service.CloudVendorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("/id/{vendorId}")
    @Operation(summary = "Cloud vendor details",
            description = "Provide cloud vendor details based on the vendor ID")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuilder(
                "Requested Vendor details are given here",
                HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId));
    }

    @GetMapping
    public ResponseEntity<Object> getAllCloudVendors(){
        return ResponseHandler.responseBuilder(
                "All Vendor details are given here",
                HttpStatus.OK, cloudVendorService.getAllCloudVendors());
    }

    @GetMapping("/name/{vendorName}")
    public ResponseEntity<Object> getCloudVendorByName(@PathVariable("vendorName") String vendorName) {
        return ResponseHandler.responseBuilder(
                "Requested Vendor details are given here",
                HttpStatus.OK, cloudVendorService.getCloudVendorByName(vendorName));
    }

    @GetMapping("/{field}")
    public ResponseEntity<Object> getAllCloudVendorsSorting(@PathVariable String field) {
        return ResponseHandler.responseBuilder(
                "Sorted Cloud Vendor details",
                HttpStatus.OK, cloudVendorService.getAllCloudVendorsWithSorting(field));
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public ResponseEntity<Object> getAllCloudVendorsPagination(@PathVariable int offset,
                                                               @PathVariable int pageSize) {
        return ResponseHandler.responseBuilder(
                "Cloud Vendor details with pagination",
                HttpStatus.OK, cloudVendorService.getAllCloudVendorsWithPagination(offset,pageSize));
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    public ResponseEntity<Object> getAllCloudVendorsPagingSorting(@PathVariable int offset,
                                                                  @PathVariable int pageSize,
                                                                  @PathVariable String field) {
        return ResponseHandler.responseBuilder(
                "Cloud Vendor details with pagination and sorting",
                HttpStatus.OK, cloudVendorService.getAllCloudVendorsWithPaginationAndSorting(offset,pageSize,field));
    }

    @PostMapping
    public ResponseEntity<Object> createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        return ResponseHandler.responseBuilder(
                "Cloud Vendor created successfully",
                HttpStatus.OK,cloudVendorService.createCloudVendor(cloudVendor));
    }

    @PutMapping
    public ResponseEntity<Object> updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        return ResponseHandler.responseBuilder(
                "Cloud Vendor updated successfully",
                HttpStatus.OK,cloudVendorService.updateCloudVendor(cloudVendor));
    }

    @DeleteMapping("/delete/{vendorId}")
    public ResponseEntity<Object> deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuilder(
                "Cloud Vendor deleted successfully",
                HttpStatus.OK, cloudVendorService.deleteCloudVendor(vendorId));
    }
}
