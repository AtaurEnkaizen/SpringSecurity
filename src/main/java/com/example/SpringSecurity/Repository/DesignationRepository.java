package com.example.SpringSecurity.Repository;

import com.example.SpringSecurity.Entity.Department;
import com.example.SpringSecurity.Entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {
}
