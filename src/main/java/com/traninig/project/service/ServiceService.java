package com.traninig.project.service;

import com.traninig.project.model.Service;
import com.traninig.project.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    ServiceRepository serviceRepository;


    public Service saveService(Service service) {
        return serviceRepository.save(service);

    }

    public List<Service> getAllservices(){
        return serviceRepository.findAll();
    }

    public Service findById (int serviceID) {
        return serviceRepository.getById(serviceID);
    }

    public Service updateService (int serviceID , Service service ){
        Service existingService = serviceRepository.findById(serviceID).orElse(null);
        existingService.setStartDate(service.getStartDate());
        existingService.setEndDate(service.getEndDate());
        existingService.setDescription(service.getDescription());
        existingService.setStatus(service.getStatus());
        return serviceRepository.save(existingService);
    }

    public void deleteService (int serviceID ){
        serviceRepository.deleteById(serviceID);

    }
}
