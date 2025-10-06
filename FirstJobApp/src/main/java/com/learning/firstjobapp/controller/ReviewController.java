package com.learning.firstjobapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.firstjobapp.model.Review;
import com.learning.firstjobapp.service.ReviewServiceInterface;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
	
	private ReviewServiceInterface reviewServiceInterface;
	
	public ReviewController(ReviewServiceInterface reviewServiceInterface) {
		super();
		this.reviewServiceInterface = reviewServiceInterface;
	}


	@GetMapping("/review")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
		return new ResponseEntity<>(reviewServiceInterface.findAllReviews(companyId),HttpStatus.OK); 
	}
	
	@PostMapping("/review")
	public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review){
		boolean isReviewAdded = reviewServiceInterface.createReview(companyId, review);
		if(isReviewAdded)
			return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
		else {
			return new ResponseEntity<>("Review NOT Added", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/review/{reviewId}")
	public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
		return new ResponseEntity<>(reviewServiceInterface.getReview(companyId,reviewId),HttpStatus.OK);
	}
	
	@PutMapping("/review/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review){
		boolean isReviewUpdated = reviewServiceInterface.updateReview(companyId,reviewId, review);
		if(isReviewUpdated)
			return new ResponseEntity<>("Review Updated",HttpStatus.OK);
		else {
			return new ResponseEntity<>("Review NOT Updated",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/review/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
		boolean isReviewDeleted = reviewServiceInterface.deleteReview(companyId,reviewId);
		if(isReviewDeleted)
			return new ResponseEntity<>("Review Deleted",HttpStatus.OK);
		else {
			return new ResponseEntity<>("Review Not Deleted",HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
