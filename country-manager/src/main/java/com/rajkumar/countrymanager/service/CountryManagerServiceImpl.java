package com.rajkumar.countrymanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajkumar.countrymanager.entity.CountryManager;
import com.rajkumar.countrymanager.repository.CountryManagerRepository;
import com.rajkumar.conutrymanager.exceptions.DetailsNotFoundException;

@Service
public class CountryManagerServiceImpl implements CountryManagerService {

	@Autowired
	public CountryManagerRepository countryManagerRepo;

	public List<CountryManager> getCountries() {
		
		return countryManagerRepo.findAll(); 
	}

	public CountryManager getCountry(int id) throws DetailsNotFoundException {
		
		if(countryManagerRepo.findById(id).get().equals(null )) 
		{
			throw new DetailsNotFoundException("Details Not Found.");
		}
			
		return countryManagerRepo.findById(id).get();
		
	}

	public CountryManager addCountry(CountryManager country) {
		
		return countryManagerRepo.save(country);
	}

	public CountryManager updateCountry(CountryManager country) {
		
		return countryManagerRepo.save(country);
	}

	public String deleteCountry(int id) {
		
		countryManagerRepo.deleteById(id);
		return "Deleted Successfully";
	}
	
}
