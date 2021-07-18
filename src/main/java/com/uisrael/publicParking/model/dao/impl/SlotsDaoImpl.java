package com.uisrael.publicParking.model.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.publicParking.model.dao.SlotsDao;

import com.uisrael.publicParking.model.entities.Slots;

public class SlotsDaoImpl extends GenericaDaoImpl<Slots> implements SlotsDao{

	@Override
	public void createSlot(Slots newSlot) {
		try {
			
			this.beginTransaction();
			this.create(newSlot);
			this.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error: " +e.getMessage());
		}
		
	}

	@Override
	public void modifySlot(Slots updateSlot) {
		try {
			
			this.beginTransaction();
			this.update(updateSlot);
			this.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error: " +e.getMessage());
		}
		
	}

	@Override
	public void deleteSlot(Slots idSlot) {
		try {
			
			this.beginTransaction();
			this.delete(idSlot);
			this.commit();
			
		} catch (Exception e) {
			
			System.out.println("Error: " +e.getMessage());
		}
		
	}

	@Override
	public List<Slots> listSlots() {
		
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();//construye el criterio de consulta
		CriteriaQuery<Slots> s = cb.createQuery(Slots.class);//mapea los datos a consultar
		Root<Slots> slot = s.from(Slots.class);//permite seleccionar la tabla origen de los datos(objeto)
		s.select(slot);//a nivel de objeto completamente
			
		return this.entityManager.createQuery(s).getResultList();
	}

	@Override
	public List<Tuple> getDataSlots() {

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> s = cb.createTupleQuery();
		Root<Slots> slot = s.from(Slots.class);
		s.select(cb.tuple(slot.get("statusSlot")));
		return this.entityManager.createQuery(s).getResultList();
		
	}

	@Override
	public List<Slots> listSlotsTQ() {
		TypedQuery<Slots> consulta = this.entityManager.createQuery("Select s from Slots s order by s.idSlot", Slots.class);
		return consulta.getResultList();
	}

	@Override
	public Slots getById(int id) {
		return this.entityManager.find(Slots.class, id);
	}

	@Override
	public List<Slots> getSlotsByStatus(int status) {

		TypedQuery<Slots> consulta = this.entityManager.createQuery("Select s from Slots s where s.statusSlot = :status order by s.idSlot", Slots.class);
		return consulta.setParameter("status", status).getResultList();
	}

}
