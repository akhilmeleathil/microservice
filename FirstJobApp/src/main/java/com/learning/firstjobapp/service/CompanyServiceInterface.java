package com.learning.firstjobapp.service;

import java.util.List;

import com.learning.firstjobapp.model.Company;

public interface CompanyServiceInterface {
	List<Company> findAllCompanies();

	void createCompany(Company company);

	Company getCompanyById(Long id);

	void deleteCompanyById(Long id);

	void updateCompany(Long id, Company updatedCompany);
}
