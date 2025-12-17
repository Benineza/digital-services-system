package com.benineza.digitalservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benineza.digitalservices.model.DigitalService;
import com.benineza.digitalservices.service.DigitalServiceService;

@RestController
@RequestMapping("/api/services")
public class DigitalServiceController {

    private final DigitalServiceService digitalServiceService;

    public DigitalServiceController(DigitalServiceService digitalServiceService) {
        this.digitalServiceService = digitalServiceService;
    }

    // GET all services
    @GetMapping
    public List<DigitalService> getAllServices() {
        return digitalServiceService.getAllServices();
    }

    // GET service by id
    @GetMapping("/{id}")
    public Optional<DigitalService> getServiceById(@PathVariable Long id) {
        return digitalServiceService.getServiceById(id);
    }

    // ADD THIS
    @PostMapping
    public DigitalService createService(@RequestBody DigitalService service) {
        return digitalServiceService.createService(service);
    }
}
