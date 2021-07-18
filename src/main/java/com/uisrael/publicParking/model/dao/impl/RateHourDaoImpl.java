package com.uisrael.publicParking.model.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.publicParking.model.dao.RateHourDao;
import com.uisrael.publicParking.model.entities.RateHour;

public class RateHourDaoImpl extends GenericaDaoImpl<RateHour> implements RateHourDao{

	@Override
	public void createRate(RateHour newRate) {
		
		try {
			
			this.beginTransaction();
			this.create(newRate);
			this.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error: " +e.getMessage());
		}
		
	}
		
	

	@Override
	public void modifyRate(RateHour updateRate) {
		try {
			
			this.beginTransaction();
			this.update(updateRate);
			this.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error: " +e.getMessage());
		}
		
	}

	@Override
	public void deleteRate(RateHour idRateHour) {
		
		try {
			
			this.beginTransaction();
			this.delete(idRateHour);
			this.commit();
			
			} catch (Exception e) {
			
			System.out.println("Error: " +e.getMessage());
		}
		
	}

	@Override
	public List<RateHour> listRate() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();//construye el criterio de consulta
		CriteriaQuery<RateHour> cli = cb.createQuery(RateHour.class);//mapea los datos a consultar
		Root<RateHour> client = cli.from(RateHour.class);//permite seleccionar la tabla origen de los datos(objeto)
		cli.select(client);//a nivel de objeto completamente
			
		return this.entityManager.createQuery(cli).getResultList();
	}

	@Override
	public List<Tuple> getDataRate() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> rate = cb.createTupleQuery();
		Root<RateHour> rateH = rate.from(RateHour.class);
		rate.select(cb.tuple(rateH.get("priceHour")));
		return this.entityManager.createQuery(rate).getResultList();
	}

	@Override
	public List<RateHour> listRateTQ() {
		TypedQuery<RateHour> consulta = this.entityManager.createQuery("Select r from RateHour r order by r.idRateHour", RateHour.class);
		return consulta.getResultList();
	}
	
	@Override
	public RateHour getById(int id) {
	    
		return this.entityManager.find(RateHour.class, id);
	}
	
	

}
