package com.uisrael.publicParking.model.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.publicParking.model.dao.VehicleTypeDao;

import com.uisrael.publicParking.model.entities.VehicleType;

public class VehicleTypeDaoImpl extends GenericaDaoImpl<VehicleType> implements VehicleTypeDao{

	@Override
	public void createVehicleT(VehicleType newVehicleT) {

		try {
			
			this.beginTransaction();
			this.create(newVehicleT);
			this.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error: " +e.getMessage());
		}
		
	}

	@Override
	public void modifyVehicleT(VehicleType updateVehicleT) {
		
		try {
			
			this.beginTransaction();
			this.update(updateVehicleT);
			this.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error: " +e.getMessage());
		}
		
	}

	@Override
	public void deleteVehicleT(VehicleType idVehicleType) {
		try {
			
			this.beginTransaction();
			this.delete(idVehicleType);
			this.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error: " +e.getMessage());
		}
		
	}

	@Override
	public List<VehicleType> listVehicleT() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();//construye el criterio de consulta
		CriteriaQuery<VehicleType> veht = cb.createQuery(VehicleType.class);//mapea los datos a consultar
		Root<VehicleType> vehicle = veht.from(VehicleType.class);//permite seleccionar la tabla origen de los datos(objeto)
		veht.select(vehicle);//a nivel de objeto completamente
			
		return this.entityManager.createQuery(veht).getResultList();
	}

	@Override
	public List<Tuple> getDataVehicleT() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> veht = cb.createTupleQuery();
		Root<VehicleType> vehicle = veht.from(VehicleType.class);
		veht.select(cb.tuple(vehicle.get("timeStart")));
		return this.entityManager.createQuery(veht).getResultList();
	}

	@Override
	public List<VehicleType> listVehicleTTQ() {
		TypedQuery<VehicleType> consulta = this.entityManager.createQuery("Select r from VehicleType r order by r.idVehicleType", VehicleType.class);
		return consulta.getResultList();
	}
	
	@Override
	public VehicleType getById(int id) {
	    
		return this.entityManager.find(VehicleType.class, id);
	}

}
