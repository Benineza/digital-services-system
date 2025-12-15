package com.benineza.digitalservices.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String status;

    private LocalDateTime requestDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Service service;

    @ManyToOne
    private ITStaff assignedStaff;

    public ServiceRequest() {
        this.requestDate = LocalDateTime.now();
        this.status = "PENDING";
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ITStaff getAssignedStaff() {
        return assignedStaff;
    }

    public void setAssignedStaff(ITStaff assignedStaff) {
        this.assignedStaff = assignedStaff;
    }
}
