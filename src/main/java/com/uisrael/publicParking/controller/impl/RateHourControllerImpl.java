package com.uisrael.publicParking.controller.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.publicParking.controller.RateHourController;

import com.uisrael.publicParking.model.dao.impl.RateHourDaoImpl;
import com.uisrael.publicParking.model.entities.RateHour;

public class RateHourControllerImpl implements RateHourController{

	private RateHourDaoImpl rateHourDao;
	

	public RateHourControllerImpl() {
		
		rateHourDao = new RateHourDaoImpl();
	}
	
	@Override
	public void createRate(RateHour newRate) {

		rateHourDao.createRate(newRate);
		
	}

	@Override
	public void modifyRate(RateHour updateRate) {
		
		rateHourDao.modifyRate(updateRate);
		
	}

	@Override
	public void deleteRate(RateHour idRateHour) {

		rateHourDao.deleteRate(idRateHour);
		
	}

	@Override
	public List<RateHour> listRate() {

		return rateHourDao.listRate();
	}

	@Override
	public List<Tuple> getDataRate() {

		return rateHourDao.getDataRate();
	}

	@Override
	public List<RateHour> listRateTQ() {

		return rateHourDao.listRateTQ();
	}

	@Override
	public RateHour getRateHourById(int id) {
		
		return rateHourDao.getById(id);
	}

}
