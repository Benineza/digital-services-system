package com.benineza.digitalservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.benineza.digitalservices.model.ITStaff;
import com.benineza.digitalservices.repository.ITStaffRepository;

@Service
public class ITStaffService {

    private final ITStaffRepository itStaffRepository;

    public ITStaffService(ITStaffRepository itStaffRepository) {
        this.itStaffRepository = itStaffRepository;
    }

    public List<ITStaff> getAllStaff() {
        return itStaffRepository.findAll();
    }

    public Optional<ITStaff> getStaffById(Long id) {
        return itStaffRepository.findById(id);
    }

    public ITStaff createStaff(ITStaff staff) {
        return itStaffRepository.save(staff);
    }

    public ITStaff updateStaff(Long id, ITStaff updatedStaff) {
        return itStaffRepository.findById(id)
                .map(staff -> {
                    staff.setName(updatedStaff.getName());
                    staff.setSpecialization(updatedStaff.getSpecialization());
                    // Add other fields
                    return itStaffRepository.save(staff);
                })
                .orElse(null);
    }

    public void deleteStaff(Long id) {
        itStaffRepository.deleteById(id);
    }
}
