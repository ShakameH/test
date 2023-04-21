package com.polytech.polywebproj.service.implementation;

import com.polytech.polywebproj.model.Speciality;
import com.polytech.polywebproj.repository.SpecialityRepository;
import com.polytech.polywebproj.service.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Speciality createSpeciality(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public List<Speciality> getSpecialities() {
        return specialityRepository.findAll();
    }

    @Override
    public Optional<Speciality> getSpecialityById(Long id) {
        return specialityRepository.findById(id);
    }

    @Override
    public Speciality modifySpeciality(Long id, Speciality speciality) {
        return specialityRepository.findById(id)
                .map(p-> {
                    p.setNameSpeciality(speciality.getNameSpeciality());
                    return specialityRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Speciality not found"));
    }

    @Override
    public String deleteSpeciality(Long id) {
        specialityRepository.deleteById(id);
        return "Speciality deleted";
    }
}
