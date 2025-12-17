package com.benineza.digitalservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.benineza.digitalservices.model.DigitalService;
import com.benineza.digitalservices.repository.DigitalServiceRepository;

@Service
public class DigitalServiceService {

    private final DigitalServiceRepository serviceRepository;

    public DigitalServiceService(DigitalServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<DigitalService> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<DigitalService> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    public DigitalService createService(DigitalService service) {
        return serviceRepository.save(service);
    }

    public DigitalService updateService(Long id, DigitalService updatedService) {
        return serviceRepository.findById(id)
                .map(service -> {
                    service.setName(updatedService.getName()); // update the fields you have in DigitalService
                    service.setDescription(updatedService.getDescription()); 
                    return serviceRepository.save(service);
                })
                .orElse(null);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
