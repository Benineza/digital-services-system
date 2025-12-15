package com.benineza.digitalservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benineza.digitalservices.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
