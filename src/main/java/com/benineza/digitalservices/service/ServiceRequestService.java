package com.benineza.digitalservices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.benineza.digitalservices.model.DigitalService;
import com.benineza.digitalservices.model.ServiceRequest;
import com.benineza.digitalservices.model.User;
import com.benineza.digitalservices.repository.DigitalServiceRepository;
import com.benineza.digitalservices.repository.ServiceRequestRepository;
import com.benineza.digitalservices.repository.UserRepository;

@Service
public class ServiceRequestService {

    private final ServiceRequestRepository requestRepository;
    private final UserRepository userRepository;
    private final DigitalServiceRepository serviceRepository;

    public ServiceRequestService(ServiceRequestRepository requestRepository,
                                 UserRepository userRepository,
                                 DigitalServiceRepository serviceRepository) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
    }

    public ServiceRequest createRequest(Long userId, List<Long> serviceIds) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<DigitalService> services = serviceRepository.findAllById(serviceIds);

        ServiceRequest request = new ServiceRequest();
        request.setUser(user);
        request.setServices(services);

        return requestRepository.save(request);
    }

    public List<ServiceRequest> getAllRequests() {
        return requestRepository.findAll();
    }
}
