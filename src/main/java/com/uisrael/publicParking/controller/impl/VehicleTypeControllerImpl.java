package com.uisrael.publicParking.controller.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.publicParking.controller.VehicleTypeController;

import com.uisrael.publicParking.model.dao.impl.VehicleTypeDaoImpl;
import com.uisrael.publicParking.model.entities.VehicleType;

public class VehicleTypeControllerImpl implements VehicleTypeController{

	private VehicleTypeDaoImpl vehicleTypeDao;
	
	public VehicleTypeControllerImpl() {
		
		vehicleTypeDao = new VehicleTypeDaoImpl();
	}
	
	@Override
	public void createVehicleT(VehicleType newVehicleT) {

		vehicleTypeDao.createVehicleT(newVehicleT);
		
	}

	@Override
	public void modifyVehicleT(VehicleType updateVehicleT) {

		vehicleTypeDao.modifyVehicleT(updateVehicleT);
		
	}

	@Override
	public void deleteVehicleT(VehicleType idVehicleType) {

		vehicleTypeDao.deleteVehicleT(idVehicleType);
		
	}

	@Override
	public List<VehicleType> listVehicleT() {

		return vehicleTypeDao.listVehicleT();
	}

	@Override
	public List<Tuple> getDataVehicleT() {

		return vehicleTypeDao.getDataVehicleT();
	}

	@Override
	public List<VehicleType> listVehicleTTQ() {

		return vehicleTypeDao.listVehicleTTQ();
	}


	@Override
	public VehicleType getVehicleTypeById(int id) {

		return vehicleTypeDao.getById(id);
	}

}
