package com.learning.firstjobapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.firstjobapp.model.Company;
import com.learning.firstjobapp.model.Review;
import com.learning.firstjobapp.repo.ReviewRepo;

@Service
public class ReviewService implements ReviewServiceInterface {

	private ReviewRepo reviewRepo;
	private CompanyService companyService;
	
	public ReviewService(ReviewRepo reviewRepo, CompanyService companyService) {
		super();
		this.reviewRepo = reviewRepo;
		this.companyService = companyService;
	}

	public List<Review> findAllReviews(Long id) {
		// TODO Auto-generated method stub
		return reviewRepo.findByCompanyId(id);
	}


	@Override
	public boolean createReview(Long id, Review review) {
		// TODO Auto-generated method stub
		Company company = companyService.getCompanyById(id);
		if(company != null) {
			review.setCompany(company);
			reviewRepo.save(review);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Review getReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		List<Review> reviews = findAllReviews(companyId);
		return reviews.stream().filter(r -> r.getId().equals(reviewId)).findFirst().orElse(null);
	}

	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
		// TODO Auto-generated method stub
		Company company = companyService.getCompanyById(companyId);
		if(company != null) {
			updatedReview.setCompany(company);
			updatedReview.setId(reviewId);
			reviewRepo.save(updatedReview);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		if(companyService.getCompanyById(companyId) != null && reviewRepo.existsById(reviewId)) {
			Review review = reviewRepo.findById(reviewId).orElse(null);
			Company company = review.getCompany();
			company.getReviews().remove(review);
			review.setCompany(null);
			companyService.updateCompany(companyId, company);
			reviewRepo.deleteById(reviewId);
			return true;
		} else
			return false;
	}

}
