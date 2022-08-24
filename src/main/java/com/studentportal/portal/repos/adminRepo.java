package com.studentportal.portal.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentportal.portal.models.admins;

public interface adminRepo extends JpaRepository<admins, Integer> {
    
}
