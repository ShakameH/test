package com.polytech.polywebproj.service.implementation;

import com.polytech.polywebproj.model.Account;
import com.polytech.polywebproj.model.Staff;
import com.polytech.polywebproj.repository.StaffRepository;
import com.polytech.polywebproj.service.StaffService;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public List<Staff> getStaffs() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public Staff modifyStaff(Long id, Staff staff) {
        return staffRepository.findById(id)
                .map(p-> {
                    p.setFirstName(staff.getFirstName());
                    p.setLastName(staff.getLastName());
                    p.setEmail(staff.getEmail());
                    p.setSignupDate(staff.getSignupDate());
                    p.setFunction(staff.getFunction());
                    p.setStaffNumber(staff.getStaffNumber());
                    p.setAccount(staff.getAccount());
                    return staffRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Staff not found"));
    }

    @Override
    public String deleteStaff(Long id) {
        staffRepository.deleteById(id);
        return "Staff deleted";
    }
}
