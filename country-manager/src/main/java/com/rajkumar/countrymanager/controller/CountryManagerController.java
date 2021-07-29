package com.rajkumar.countrymanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rajkumar.conutrymanager.exceptions.DetailsNotFoundException;
import com.rajkumar.countrymanager.entity.CountryManager;
import com.rajkumar.countrymanager.service.CountryManagerService;

@RestController
//@RequestMapping("/countries")
public class CountryManagerController {

	@Autowired
	public CountryManagerService countryManagerService;
	
	
	@GetMapping("/countries")
	public ResponseEntity getCountries(@RequestHeader(value="Authorization") String authorizeToken)
	{
		
		if(!validateManager(authorizeToken)) 
			{
	 			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized Access Grant");
	 		}
		else 
			{
				return ResponseEntity.status(HttpStatus.OK).body(this.countryManagerService.getCountries());
			}
	}
	
 	@GetMapping("countrybyid/{id}")
 	public ResponseEntity getCountry(@PathVariable int id, 
 			@RequestHeader(value="Authorization") String authorizeToken) throws DetailsNotFoundException  
 	{
 		
 		if(!validateManager(authorizeToken)) 
 			{
	 			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized Access Grant");
	 		}
		else 
			{
				return ResponseEntity.status(HttpStatus.OK).body(this.countryManagerService.getCountry(id));
			}
 	}

 	@PostMapping("addcountry")
 	public ResponseEntity addCountry(@RequestBody CountryManager country, 
 			@RequestHeader(value="Authorization") String authorizeToken ) 
 	{
		
 		if(!validateManager(authorizeToken)) 
 		{
 			
 			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized Access Grant");
 		}
 		else 
 		{ 			
 			return ResponseEntity.status(HttpStatus.OK).body(this.countryManagerService.addCountry(country));
 		}
 	}
 		
 	@PutMapping("/updatecountry")
 	public ResponseEntity updateCountry(@RequestBody CountryManager country,
 			@RequestHeader(value="Authorization") String authorizeToken ) 
 	{
 		
 		if(!validateManager(authorizeToken)) 
 			{
 	 			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized Access Grant");
 	 		}
 	 	else 
 	 		{ 	
 	 			return ResponseEntity.status(HttpStatus.OK).body(this.countryManagerService.updateCountry(country));
 	 		}
 	}
 	
 	@DeleteMapping("/deletebyid/{id}")
 	public ResponseEntity deleteCountry(@PathVariable int id,  
 			@RequestHeader(value="Authorization") String authorizeToken ) throws DetailsNotFoundException 
 	{
 		
 		if(!validateManager(authorizeToken))
 			{
 				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized Access Grant");
 	 		}
 	 		else { 	
 	 			return ResponseEntity.status(HttpStatus.OK).body(this.countryManagerService.deleteCountry(id));
 	 		}
 	}
 	
 	public boolean validateManager(String authorizeToken) 
 	{
 		String[] authorize = authorizeToken.split(" ");
 		if(authorize[1].equals("myauthtoken"))
 		{
 			return true;
 		}
 		return false; 		
 	}
}
