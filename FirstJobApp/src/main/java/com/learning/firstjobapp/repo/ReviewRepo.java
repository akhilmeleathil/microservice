package com.learning.firstjobapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.firstjobapp.model.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {

	List<Review> findByCompanyId(Long id);

}
