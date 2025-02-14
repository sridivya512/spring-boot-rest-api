package com.divya.rest_demo.repository;

import com.divya.rest_demo.model.CloudVendor;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String>{
    List<CloudVendor> findByVendorName(String vendorName);
}
