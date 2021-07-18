package com.uisrael.publicParking.controller.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.publicParking.controller.RegisterParkingController;
import com.uisrael.publicParking.model.dao.RegisterParkingDao;
import com.uisrael.publicParking.model.dao.impl.RegisterParkingDaoImpl;
import com.uisrael.publicParking.model.entities.RegisterParking;

public class RegisterParkingControllerImpl implements RegisterParkingController{

	
	private RegisterParkingDao registerParkingDao;
	
	public RegisterParkingControllerImpl() {
		
		registerParkingDao = new RegisterParkingDaoImpl();
	}
	
	@Override
	public void createRegister(RegisterParking newRegister) {

		registerParkingDao.createRegister(newRegister);
		
	}

	@Override
	public void modifyRegister(RegisterParking updateRegister) {

		registerParkingDao.modifyRegister(updateRegister);
		
	}

	@Override
	public void deleteRegister(RegisterParking idRegisterParking) {
		
		registerParkingDao.deleteRegister(idRegisterParking);
		
	}

	@Override
	public List<RegisterParking> listRegister() {

		return registerParkingDao.listRegister();
	}

	@Override
	public List<Tuple> getDataRegister() {

		return registerParkingDao.getDataRegister();
	}

	@Override
	public List<RegisterParking> listRegisterTQ() {

		return registerParkingDao.listRegisterTQ();
	}

	@Override
	public List<RegisterParking> searchRegisterDate(String registerDate) {

		return registerParkingDao.searchRegisterDate(registerDate);
	}

}
