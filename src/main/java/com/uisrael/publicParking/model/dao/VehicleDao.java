package com.uisrael.publicParking.model.dao;

import java.util.List;

import javax.persistence.Tuple;


import com.uisrael.publicParking.model.entities.Vehicle;

public interface VehicleDao {

	public Vehicle createVehicle(Vehicle newVehicle);
	
	public void modifyVehicle(Vehicle updateVehicle);
	
	public void deleteVehicle(Vehicle idVehicle);
	
	public List<Vehicle> listVehicle();
	
	public List<Tuple> getDataVehicle();
	
	public List<Vehicle> listVehicleTQ();
	
	public List<Vehicle> searchVehicle(String number);
	
	public Vehicle getVehicleById(int id);
}
