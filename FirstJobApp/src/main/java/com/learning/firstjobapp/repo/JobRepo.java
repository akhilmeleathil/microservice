package com.learning.firstjobapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.firstjobapp.model.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {

}
