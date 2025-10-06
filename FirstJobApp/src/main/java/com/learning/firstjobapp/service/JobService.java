package com.learning.firstjobapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.firstjobapp.model.Job;

@Service
public class JobService implements JobServiceInterface{
	
	List<Job> jobs = new ArrayList<>();

	@Override
	public List<Job> findAllJob() {
		return jobs;
	}

	@Override
	public void createJob(Job job) {
		jobs.add(job);
	}

	public Job getJobById(int id) {
		for (Job job : jobs) {
			if(job.getJobId()==id) {
				return job;
			}
		}
		return null;
	}

	public void deleteJobById(int id) {
		for (Job job : jobs) {
			if(job.getJobId() == id) {
				jobs.remove(job);
			}
		}
		
	}

	@Override
	public void updateJob(int id, Job updatedJob) {
		for (Job job : jobs) {
			if(job.getJobId() == id) {
				job.setDescription(updatedJob.getDescription());
				job.setMinSalary(updatedJob.getMinSalary());
				job.setTitle(updatedJob.getTitle());
				job.setMaxSalary(updatedJob.getMaxSalary());
				job.setLocation(updatedJob.getLocation());
			}
		}
		
	}

}
