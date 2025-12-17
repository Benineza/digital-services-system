package com.benineza.digitalservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benineza.digitalservices.model.DigitalService;

public interface DigitalServiceRepository extends JpaRepository<DigitalService, Long> {
}
