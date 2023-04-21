package com.polytech.polywebproj.service;

import com.polytech.polywebproj.model.Staff;
import com.polytech.polywebproj.model.Student;

import java.util.List;
import java.util.Optional;

public interface StaffService {

    Staff createStaff(Staff staff);

    List<Staff> getStaffs();

    Optional<Staff> getStaffById(Long id);

    Staff modifyStaff(Long id, Staff staff);

    String deleteStaff(Long id);
}
