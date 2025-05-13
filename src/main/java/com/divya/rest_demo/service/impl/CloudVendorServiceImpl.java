package com.divya.rest_demo.service.impl;

import com.divya.rest_demo.exception.CloudVendorNotFoundException;
import com.divya.rest_demo.model.CloudVendor;
import com.divya.rest_demo.repository.CloudVendorRepository;
import com.divya.rest_demo.service.CloudVendorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        Optional<CloudVendor> optionalCloudVendorvendor = cloudVendorRepository.findById(cloudVendorId);
        if(optionalCloudVendorvendor.isEmpty()){
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        }
        return optionalCloudVendorvendor.get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> getCloudVendorByName(String cloudVendorName) {
        return cloudVendorRepository.findByVendorName(cloudVendorName);
    }

    @Override
    public List<CloudVendor> getAllCloudVendorsWithSorting(String field) {
        System.out.println("field:"+field);
        return cloudVendorRepository.findAll(Sort.by(Sort.Direction.DESC,field));
    }

    @Override
    public Page<CloudVendor> getAllCloudVendorsWithPagination(int offset, int pageSize) {
        return cloudVendorRepository.findAll(PageRequest.of(offset,pageSize));
    }

    @Override
    public Page<CloudVendor> getAllCloudVendorsWithPaginationAndSorting(int offset, int pageSize, String field) {
        return cloudVendorRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(field)));
    }


//    @PostConstruct
//    public void initDB() {
//        List<CloudVendor> cloudVendorList = IntStream.rangeClosed(1, 200)
//                .mapToObj(i -> new CloudVendor(
//                        "Vendor-" + i,
//                        "Address-" + new Random().nextInt(100),
//                        "Phone-" + (1000000000 + new Random().nextInt(900000000))
//                ))
//                .collect(Collectors.toList());
//
//        cloudVendorRepository.saveAll(cloudVendorList);
//    }


}
