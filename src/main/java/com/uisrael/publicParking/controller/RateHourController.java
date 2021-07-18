package com.uisrael.publicParking.controller;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.publicParking.model.entities.RateHour;

public interface RateHourController {

	public void createRate(RateHour newRate);
	
	public void modifyRate(RateHour updateRate);
	
	public void deleteRate(RateHour idRateHour);
	
	public List<RateHour> listRate();
	
	public List<Tuple> getDataRate();
	
	public List<RateHour> listRateTQ(); // listar con type query
	
	public RateHour getRateHourById(int id);

	
}
