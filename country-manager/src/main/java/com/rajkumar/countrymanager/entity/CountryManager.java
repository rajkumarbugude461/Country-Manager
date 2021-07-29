package com.rajkumar.countrymanager.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountryManager 
{
	
	@Id
	private int countryId;
	private String countryName;
	private String nationalLanguage;
	private long population;
	private Date dbupdatedate;
	
	
	public CountryManager() 
	{
		super();
		
	}
	
	
	public CountryManager(int countryId, String countryName, String nationalLanguage, long population,
			Date dbupdatedate)
	{
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.nationalLanguage = nationalLanguage;
		this.population = population;
		this.dbupdatedate = dbupdatedate;
	}


	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getNationalLanguage() {
		return nationalLanguage;
	}
	public void setNationalLanguage(String nationalLanguage) {
		this.nationalLanguage = nationalLanguage;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public Date getDbupdatedate() {
		return dbupdatedate;
	}
	public void setDbupdatedate(Date dbupdatedate) {
		this.dbupdatedate = dbupdatedate;
	}
	@Override
	public String toString() {
		return "CountryManager [countryId=" + countryId + ", countryName=" + countryName + ", nationalLanguage="
				+ nationalLanguage + ", population=" + population + ", dbupdatedate=" + dbupdatedate + "]";
	}
	
	
}
