package com.polytech.polywebproj.controller;

import com.polytech.polywebproj.model.Speciality;
import com.polytech.polywebproj.model.Staff;
import com.polytech.polywebproj.service.SpecialityService;
import com.polytech.polywebproj.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/polywebproj/speciality")
public class SpecialityController {
    private final SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @PostMapping("/create")
    public Speciality createSpeciality(@RequestBody Speciality speciality) {
        return specialityService.createSpeciality(speciality);
    }

    @GetMapping
    public List<Speciality> getSpecialities() {
        return specialityService.getSpecialities();
    }

    @GetMapping(value="/{id}")
    public Optional<Speciality> getSpecialityById(@PathVariable Long id) {
        return specialityService.getSpecialityById(id);
    }

    @PutMapping("/update/{id}")
    public Speciality modifySpeciality(@PathVariable Long id, @RequestBody Speciality speciality) {
        return specialityService.modifySpeciality(id, speciality);
    }

    @DeleteMapping("/delete")
    public String deleteSpeciality(Long id) {
        return specialityService.deleteSpeciality(id);
    }
}
