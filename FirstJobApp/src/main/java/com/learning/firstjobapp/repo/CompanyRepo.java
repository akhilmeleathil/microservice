package com.learning.firstjobapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.firstjobapp.model.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {

}
