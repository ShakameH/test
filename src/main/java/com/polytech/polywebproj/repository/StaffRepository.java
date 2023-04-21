package com.polytech.polywebproj.repository;

import com.polytech.polywebproj.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
