package com.polytech.polywebproj.controller;

import com.polytech.polywebproj.model.Staff;
import com.polytech.polywebproj.model.Student;
import com.polytech.polywebproj.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/polywebproj/staff")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/create")
    public Staff createStaff(@RequestBody Staff staff) {
        return staffService.createStaff(staff);
    }

    @GetMapping
    public List<Staff> getStaffs() {
        return staffService.getStaffs();
    }

    @GetMapping(value="/{id}")
    public Optional<Staff> getStaffById(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }

    @PutMapping("/update/{id}")
    public Staff modifyStaff(@PathVariable Long id, @RequestBody Staff staff) {
        return staffService.modifyStaff(id, staff);
    }

    @DeleteMapping("/delete")
    public String deleteStaff(Long id) {
        return staffService.deleteStaff(id);
    }
}
