package com.learning.firstjobapp.service;

import java.util.List;
import com.learning.firstjobapp.repo.CompanyRepo;
import org.springframework.stereotype.Service;

import com.learning.firstjobapp.model.Company;

@Service
public class CompanyService implements CompanyServiceInterface {

    private final CompanyRepo companyRepo;

    CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

	public List<Company> findAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepo.findAll();
	}

	@Override
	public void createCompany(Company company) {
		// TODO Auto-generated method stub
		companyRepo.save(company);
		
	}

	@Override
	public Company getCompanyById(Long id) {
		// TODO Auto-generated method stub
		return companyRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteCompanyById(Long id) {
		// TODO Auto-generated method stub
		if(companyRepo.existsById(id))
			companyRepo.deleteById(id);
		
	}

	@Override
	public void updateCompany(Long id, Company updatedCompany) {
		// TODO Auto-generated method stub
		Company company = companyRepo.findById(id).orElse(null);
		if(company != null) {
			company.setDescription(updatedCompany.getDescription());
			company.setName(updatedCompany.getName());
			companyRepo.save(company);
		}
	}

}
