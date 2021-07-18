package com.uisrael.publicParking.model.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.publicParking.model.entities.RateHour;

public interface RateHourDao {
	
	public void createRate(RateHour newRate);
	
	public void modifyRate(RateHour updateRate);
	
	public void deleteRate(RateHour idRateHour);
	
	public List<RateHour> listRate();
	
	public List<Tuple> getDataRate();
	
	public List<RateHour> listRateTQ(); // listar con type query
	
	public RateHour getById(int id);

}
