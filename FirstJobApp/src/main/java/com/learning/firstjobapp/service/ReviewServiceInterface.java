package com.learning.firstjobapp.service;

import java.util.List;

import com.learning.firstjobapp.model.Review;

public interface ReviewServiceInterface {

	List<Review> findAllReviews(Long companyId);

	boolean createReview(Long companyId, Review review);

	Review getReview(Long companyId, Long reviewId);

	boolean updateReview(Long companyId, Long reviewId, Review review);

	boolean deleteReview(Long companyId, Long reviewId);

}
