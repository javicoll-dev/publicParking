package com.uisrael.publicParking.model.dao;

import java.util.List;

import javax.persistence.Tuple;


import com.uisrael.publicParking.model.entities.VehicleType;

public interface VehicleTypeDao {

	public void createVehicleT(VehicleType newVehicleT);
	
	public void modifyVehicleT(VehicleType updateVehicleT);
	
	public void deleteVehicleT(VehicleType idVehicleType);
	
	public List<VehicleType> listVehicleT();
	
	public List<Tuple> getDataVehicleT();
	
	public List<VehicleType> listVehicleTTQ();
	
	public VehicleType getById(int id);
}
