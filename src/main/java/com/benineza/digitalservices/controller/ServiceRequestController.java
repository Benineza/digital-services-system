package com.benineza.digitalservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benineza.digitalservices.model.ServiceRequest;
import com.benineza.digitalservices.service.ServiceRequestService;

@RestController
@RequestMapping("/api/requests")
public class ServiceRequestController {

    private final ServiceRequestService requestService;

    public ServiceRequestController(ServiceRequestService requestService) {
        this.requestService = requestService;
    }

    // POST /api/requests
    @PostMapping
    public ServiceRequest createRequest(@RequestBody RequestDto dto) {
        return requestService.createRequest(dto.getUserId(), dto.getServiceIds());
    }

    // GET /api/requests
    @GetMapping
    public List<ServiceRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    // DTO for incoming JSON
    public static class RequestDto {
        private Long userId;
        private List<Long> serviceIds;

        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }

        public List<Long> getServiceIds() { return serviceIds; }
        public void setServiceIds(List<Long> serviceIds) { this.serviceIds = serviceIds; }
    }
}
