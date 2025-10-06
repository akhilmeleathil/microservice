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
import org.springframework.web.bind.annotation.RestController;

import com.learning.firstjobapp.model.Job;
import com.learning.firstjobapp.service.JobServiceInterface;

@RestController
public class JobController {
	
	private JobServiceInterface jobServiceInterface;
	
	
	public JobController(JobServiceInterface jobServiceInterface) {
		this.jobServiceInterface = jobServiceInterface;
	}


	@GetMapping("/Jobs")
	public ResponseEntity<List<Job>> getAllJobs(){
		return ResponseEntity.ok(jobServiceInterface.findAllJob());
	}
	
	@PostMapping("/Jobs")
	public ResponseEntity<String> createJob(@RequestBody Job job){
		jobServiceInterface.createJob(job);
		return new ResponseEntity<String>("Job Added", HttpStatus.OK);
	}
	
	@GetMapping("/Jobs/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable int id){
		return new ResponseEntity<Job>(jobServiceInterface.getJobById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/Jobs/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable int id){
		jobServiceInterface.deleteJobById(id);
		return new ResponseEntity<String>("Job Deleted", HttpStatus.OK);
	}
	
	@PutMapping("/Jobs/{id}")
	//@RequestMapping(value = "/Jobs/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateJob(@PathVariable int id, @RequestBody Job updatedJob){
		jobServiceInterface.updateJob(id, updatedJob);
		return new ResponseEntity<String>("Job Updated", HttpStatus.OK);
		
	}

}
