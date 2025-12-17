package com.benineza.digitalservices.controller;

import com.benineza.digitalservices.model.ITStaff;
import com.benineza.digitalservices.service.ITStaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/it-staff")
public class ITStaffController {

    private final ITStaffService itStaffService;

    public ITStaffController(ITStaffService itStaffService) {
        this.itStaffService = itStaffService;
    }

    @GetMapping
    public List<ITStaff> getAllStaff() {
        return itStaffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public ITStaff getStaffById(@PathVariable Long id) {
        return itStaffService.getStaffById(id).orElse(null);
    }

    @PostMapping
    public ITStaff createStaff(@RequestBody ITStaff staff) {
        return itStaffService.createStaff(staff);
    }

    @PutMapping("/{id}")
    public ITStaff updateStaff(@PathVariable Long id, @RequestBody ITStaff updatedStaff) {
        return itStaffService.updateStaff(id, updatedStaff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        itStaffService.deleteStaff(id);
    }
}
