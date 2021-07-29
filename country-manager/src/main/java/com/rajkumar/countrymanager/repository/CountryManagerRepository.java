package com.rajkumar.countrymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajkumar.countrymanager.entity.CountryManager;

@Repository
public interface CountryManagerRepository extends JpaRepository<CountryManager, Integer>{

	

	
}
