package com.uisrael.publicParking.model.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.publicParking.model.dao.VehicleDao;

import com.uisrael.publicParking.model.entities.Vehicle;

public class VehicleDaoImpl extends GenericaDaoImpl<Vehicle> implements VehicleDao{

	@Override
	public Vehicle createVehicle(Vehicle newVehicle) {
	Vehicle recoveryVehicle=null;
	try {
			
			this.beginTransaction();
			recoveryVehicle=this.create(newVehicle);
			this.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error: " +e.getMessage());
		}
		
	return recoveryVehicle;
	}

	@Override
	public void modifyVehicle(Vehicle updateVehicle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVehicle(Vehicle idVehicle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vehicle> listVehicle() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();//construye el criterio de consulta
		CriteriaQuery<Vehicle> veh = cb.createQuery(Vehicle.class);//mapea los datos a consultar
		Root<Vehicle> vehicle = veh.from(Vehicle.class);//permite seleccionar la tabla origen de los datos(objeto)
		veh.select(vehicle);//a nivel de objeto completamente
			
		return this.entityManager.createQuery(veh).getResultList();
	}

	@Override
	public List<Tuple> getDataVehicle() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> veh = cb.createTupleQuery();
		Root<Vehicle> vehicle = veh.from(Vehicle.class);
		veh.select(cb.tuple(vehicle.get("timeStart")));
		return this.entityManager.createQuery(veh).getResultList();
	}

	@Override
	public List<Vehicle> listVehicleTQ() {
		TypedQuery<Vehicle> consulta = this.entityManager.createQuery("Select v from Vehicle v order by v.idVehicle", Vehicle.class);
		return consulta.getResultList();
	}

	@Override
	public List<Vehicle> searchVehicle(String number) {
		TypedQuery<Vehicle> consulta = this.entityManager.createQuery("Select v from Vehicle v where v.number = '" + number+ " ' ", Vehicle.class);
		
		return consulta.getResultList();
	}

	@Override
	public Vehicle getVehicleById(int id) {
		return this.entityManager.find(Vehicle.class, id);
	}

}
