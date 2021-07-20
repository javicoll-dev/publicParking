package com.uisrael.publicParking.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.publicParking.model.entities.RegisterParking;

public interface RegisterParkingController {

	public void createRegister(RegisterParking newRegister);
	
	public void modifyRegister(RegisterParking updateRegister);
	
	public void deleteRegister(RegisterParking idRegisterParking);
	
	public List<RegisterParking> listRegister();
	
	public List<Tuple> getDataRegister();
	
	public List<RegisterParking> listRegisterTQ(int statusR);
	
	public List<RegisterParking> listRegisterHistoryTQ(int statusP, Date end );
	
	public List<RegisterParking> searchRegisterDate(String registerDate);
	
	public float getTotalOfDayTQ(int statusP, Date end); 
	
}
