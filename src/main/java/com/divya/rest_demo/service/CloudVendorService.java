package com.divya.rest_demo.service;

import com.divya.rest_demo.model.CloudVendor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CloudVendorService {
    String createCloudVendor(CloudVendor cloudVendor);
    String updateCloudVendor(CloudVendor cloudVendor);
    String deleteCloudVendor(String cloudVendorId);
    CloudVendor getCloudVendor(String cloudVendorId);
    List<CloudVendor> getAllCloudVendors();
    List<CloudVendor> getCloudVendorByName(String cloudVendorName);
    List<CloudVendor> getAllCloudVendorsWithSorting(String field);
    Page<CloudVendor> getAllCloudVendorsWithPagination(int offset, int pageSize);
    Page<CloudVendor> getAllCloudVendorsWithPaginationAndSorting(int offset, int pageSize, String field);
}
