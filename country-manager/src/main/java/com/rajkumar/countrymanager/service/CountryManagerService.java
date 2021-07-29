package com.rajkumar.countrymanager.service;

import java.util.List;

import com.rajkumar.conutrymanager.exceptions.DetailsNotFoundException;
import com.rajkumar.countrymanager.entity.CountryManager;

public interface CountryManagerService {

	public List<CountryManager> getCountries();

	public CountryManager getCountry(int id) throws DetailsNotFoundException;
	
	public CountryManager addCountry(CountryManager country);
	
	public CountryManager updateCountry(CountryManager country);

	public String deleteCountry(int id) throws DetailsNotFoundException;

}
