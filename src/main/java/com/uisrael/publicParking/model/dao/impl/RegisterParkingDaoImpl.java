package com.uisrael.publicParking.model.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.publicParking.model.dao.RegisterParkingDao;
import com.uisrael.publicParking.model.entities.RegisterParking;

public class RegisterParkingDaoImpl extends GenericaDaoImpl<RegisterParking> implements RegisterParkingDao{

	@Override
	public void createRegister(RegisterParking newRegister) {

		try {
			
			this.beginTransaction();
			this.create(newRegister);
			this.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error: " +e.getMessage());
		}
		
	}

	@Override
	public void modifyRegister(RegisterParking updateRegister) {
		try {
			
			this.beginTransaction();
			this.update(updateRegister);
			this.commit();
			
			} catch (Exception e) {
			
			System.out.println("Error: " +e.getMessage());
		}
		
	}

	@Override
	public void deleteRegister(RegisterParking idRegisterParking) {
		try {
			
			this.beginTransaction();
			this.delete(idRegisterParking);
			this.commit();
			
			} catch (Exception e) {
			
			System.out.println("Error: " +e.getMessage());
		}
		
	}

	@Override
	public List<RegisterParking> listRegister() {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();//construye el criterio de consulta
		CriteriaQuery<RegisterParking> reg = cb.createQuery(RegisterParking.class);//mapea los datos a consultar
		Root<RegisterParking> register = reg.from(RegisterParking.class);//permite seleccionar la tabla origen de los datos(objeto)
		reg.select(register);//a nivel de objeto completamente
			
		return this.entityManager.createQuery(reg).getResultList();
	}

	@Override
	public List<Tuple> getDataRegister() {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> reg = cb.createTupleQuery();
		Root<RegisterParking> register = reg.from(RegisterParking.class);
		reg.select(cb.tuple(register.get("timeStart"), cb.tuple(register.get("timeEnd"))));
		return this.entityManager.createQuery(reg).getResultList();
	}

	@Override
	public List<RegisterParking> listRegisterTQ() {
		TypedQuery<RegisterParking> consulta = this.entityManager.createQuery("Select r from RegisterParking r order by r.idRegisterParking", RegisterParking.class);
		return consulta.getResultList();
	}

	@Override
	public List<RegisterParking> searchRegisterDate(String registerDate) {
		
		TypedQuery<RegisterParking> consulta = this.entityManager.createQuery("Select r from RegisterParking r where r.registerDate = '" + registerDate+ " ' ", RegisterParking.class);
		return consulta.getResultList();
	}

}
