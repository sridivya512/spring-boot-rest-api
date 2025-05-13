package com.divya.rest_demo.service.impl;

import com.divya.rest_demo.exception.CloudVendorNotFoundException;
import com.divya.rest_demo.model.CloudVendor;
import com.divya.rest_demo.repository.CloudVendorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;

    @InjectMocks
    private CloudVendorServiceImpl cloudVendorService;

    private CloudVendor cloudVendor;
    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor(1,"Amazon","USA","xxxxx");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor_success() {
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        String result = cloudVendorService.createCloudVendor(cloudVendor);
        assertEquals("Success",result);
        verify(cloudVendorRepository, times(1)).save(cloudVendor);
    }

    @Test
    void testUpdateCloudVendor_success() {
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        String result = cloudVendorService.updateCloudVendor(cloudVendor);
        assertEquals("Success",result);
        verify(cloudVendorRepository, times(1)).save(cloudVendor);
    }

    @Test
    void testDeleteCloudVendor_success() {
        doNothing().when(cloudVendorRepository).deleteById(any());
        String result = cloudVendorService.deleteCloudVendor("1");
        assertEquals("Success",result);
        verify(cloudVendorRepository, times(1)).deleteById("1");
    }

    @Test
    void testGetCloudVendor_Success() {
        when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
        CloudVendor result = cloudVendorService.getCloudVendor("1");
        assertNotNull(result);
        assertEquals("Amazon",result.getVendorName());
        verify(cloudVendorRepository,times(1)).findById("1");
    }

    @Test
    void testGetCloudVendor_Fail() {
        when(cloudVendorRepository.findById("1")).thenReturn(Optional.empty());
        assertThrows(CloudVendorNotFoundException.class,
                ()-> cloudVendorService.getCloudVendor("1"));
        verify(cloudVendorRepository,times(1)).findById("1");
    }

    @Test
    void testGetAllCloudVendors_success() {
        when(cloudVendorRepository.findAll()).thenReturn(new ArrayList<CloudVendor>(Collections.singletonList(cloudVendor)));
        String result_vendorphone = cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber();
        assertEquals(result_vendorphone,cloudVendor.getVendorPhoneNumber());
        verify(cloudVendorRepository,times(1)).findAll();
    }

    @Test
    void testGetCloudVendorByName_success() {
        when(cloudVendorRepository.findByVendorName("Amazon")).
                thenReturn(new ArrayList<CloudVendor>(Collections.singletonList(cloudVendor)));
        int result_vendorId = cloudVendorService.getCloudVendorByName("Amazon").get(0).getVendorId();
        assertEquals(result_vendorId,cloudVendor.getVendorId());
        verify(cloudVendorRepository,times(1)).findByVendorName("Amazon");
    }
}