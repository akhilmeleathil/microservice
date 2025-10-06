package com.learning.firstjobapp.service;

import java.util.List;

import com.learning.firstjobapp.model.Job;


public interface JobServiceInterface {
	List<Job> findAllJob();
	void createJob(Job job);
	Job getJobById(int id);
	void deleteJobById(int id);
	void updateJob(int id, Job updatedJob);
}
