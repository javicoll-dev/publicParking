package com.uisrael.publicParking.model.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
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
	public List<RegisterParking> listRegisterTQ(int statusR) {
		TypedQuery<RegisterParking> consulta = this.entityManager.createQuery("Select r from RegisterParking r where r.statusRegParking = :statusR order by r.idRegisterParking", RegisterParking.class);
		return consulta.setParameter("statusR", statusR).getResultList();
	}

	@Override
	public List<RegisterParking> searchRegisterDate(String registerDate) {
		
		TypedQuery<RegisterParking> consulta = this.entityManager.createQuery("Select r from RegisterParking r where r.registerDate = '" + registerDate+ " ' ", RegisterParking.class);
		return consulta.getResultList();
	}

	@Override
	public List<RegisterParking> listRegisterHistoryTQ(int statusP, Date end) {

		
        Date date1 = (Date) end.clone();//se crea una copia del valor recibido en la variable end(fecha) y le asigno a la variable date1
        
        date1.setHours(0);
        date1.setMinutes(0);
        date1.setSeconds(0);

        Date date2 = (Date) end.clone();
        
        date2.setHours(23);
        date2.setMinutes(59);
        date2.setSeconds(59);

        
		TypedQuery<RegisterParking> consulta = this.entityManager.createQuery("Select r from RegisterParking r where r.statusRegParking = :statusP and  r.timeEnd between :date1 and :date2 order by r.idRegisterParking", RegisterParking.class);
		
		return consulta.setParameter("statusP", statusP).setParameter("date1", date1).setParameter("date2", date2).getResultList();
	}

	@Override
	public float getTotalOfDayTQ(int statusP, Date end) {
	
		 Date date1 = (Date) end.clone();//se crea una copia del valor recibido en la variable end(fecha) y le asigno a la variable date1
	        
	        date1.setHours(0);
	        date1.setMinutes(0);
	        date1.setSeconds(0);

	        Date date2 = (Date) end.clone();
	        
	        date2.setHours(23);
	        date2.setMinutes(59);
	        date2.setSeconds(59);

	        
			Query consulta = this.entityManager.createQuery("Select sum(r.totalRate) from RegisterParking r where r.statusRegParking = :statusP and  r.timeEnd between :date1 and :date2 ");
			
			return (float) consulta.setParameter("statusP", statusP).setParameter("date1", date1).setParameter("date2", date2).getSingleResult();
	}

}
