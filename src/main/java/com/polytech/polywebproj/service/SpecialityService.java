package com.polytech.polywebproj.service;

import com.polytech.polywebproj.model.Speciality;
import com.polytech.polywebproj.model.Staff;

import java.util.List;
import java.util.Optional;

public interface SpecialityService {

    Speciality createSpeciality(Speciality speciality);

    List<Speciality> getSpecialities();

    Optional<Speciality> getSpecialityById(Long id);

    Speciality modifySpeciality(Long id, Speciality speciality);

    String deleteSpeciality(Long id);
}
