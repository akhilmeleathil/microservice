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

import com.learning.firstjobapp.model.Company;
import com.learning.firstjobapp.service.CompanyServiceInterface;

@RestController()
@RequestMapping("/companies")
public class CompanyController {
	
	private CompanyServiceInterface companyServiceInterface;

	public CompanyController(CompanyServiceInterface companyServiceInterface) {
		super();
		this.companyServiceInterface = companyServiceInterface;
	}
	
	@GetMapping()
	public ResponseEntity<List<Company>> findCompanies(){
		return new ResponseEntity<>(companyServiceInterface.findAllCompanies(),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<String> createCompany(@RequestBody Company company){
		companyServiceInterface.createCompany(company);
		return new ResponseEntity<String>("Company Added", HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
		return new ResponseEntity<Company>(companyServiceInterface.getCompanyById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id){
		companyServiceInterface.deleteCompanyById(id);
		return new ResponseEntity<String>("Company Deleted", HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	//@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company updatedCompany){
		companyServiceInterface.updateCompany(id, updatedCompany);
		return new ResponseEntity<String>("Company Updated", HttpStatus.OK);
		
	}

}
