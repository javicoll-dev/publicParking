package com.uisrael.publicParking.controller.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.publicParking.controller.VehicleController;
import com.uisrael.publicParking.model.dao.VehicleDao;
import com.uisrael.publicParking.model.dao.impl.VehicleDaoImpl;
import com.uisrael.publicParking.model.entities.Vehicle;

public class VehicleControllerImpl implements VehicleController{
	
	private VehicleDao vehicleDao;
	
	public VehicleControllerImpl() {
		
		vehicleDao = new VehicleDaoImpl();
	}

	@Override
	public Vehicle createVehicle(Vehicle newVehicle) {

		return vehicleDao.createVehicle(newVehicle);
		
	}

	@Override
	public void modifyVehicle(Vehicle updateVehicle) {

		vehicleDao.modifyVehicle(updateVehicle);
	}

	@Override
	public void deleteVehicle(Vehicle idVehicle) {

		vehicleDao.deleteVehicle(idVehicle);
		
	}

	@Override
	public List<Vehicle> listVehicle() {

		return vehicleDao.listVehicle();
	}

	@Override
	public List<Tuple> getDataVehicle() {

		return vehicleDao.getDataVehicle();
	}

	@Override
	public List<Vehicle> listVehicleTQ() {

		return vehicleDao.listVehicleTQ();
	}

	@Override
	public List<Vehicle> searchVehicle(String number) {

		return vehicleDao.searchVehicle(number);
	}

	@Override
	public Vehicle getVehicleById(int id) {
		// TODO Auto-generated method stub
		return vehicleDao.getVehicleById(id);
	}

}
