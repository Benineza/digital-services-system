package com.benineza.digitalservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benineza.digitalservices.model.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
}
