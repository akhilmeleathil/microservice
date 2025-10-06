package com.learning.firstjobapp.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.learning.firstjobapp.model.Job;
import com.learning.firstjobapp.repo.JobRepo;

@Service
@Primary
public class JobServiceJpa implements JobServiceInterface{
	
	private JobRepo jobRepo;

	public JobServiceJpa(JobRepo jobRepo) {
		super();
		this.jobRepo = jobRepo;
	}
	
	@Override
	public List<Job> findAllJob() {
		// TODO Auto-generated method stub
		return jobRepo.findAll();
	}

	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		System.out.println("Inside createJob");
		jobRepo.save(job);
	}

	@Override
	public Job getJobById(int id) {
		// TODO Auto-generated method stub
		return jobRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteJobById(int id) {
		// TODO Auto-generated method stub
		jobRepo.deleteById(id);
	}

	@Override
	public void updateJob(int id, Job updatedJob) {
		// TODO Auto-generated method stub
		Job job = jobRepo.findById(id).orElse(null);
		System.out.println("Job = "+job.toString());
		if(job != null) {
			job.setDescription(updatedJob.getDescription());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setTitle(updatedJob.getTitle());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setLocation(updatedJob.getLocation());
			jobRepo.save(job);
		}
	}

}
