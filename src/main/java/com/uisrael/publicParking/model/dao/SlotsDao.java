package com.uisrael.publicParking.model.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.publicParking.model.entities.Slots;



public interface SlotsDao {
	
	public void createSlot(Slots newSlot);
	
	public void modifySlot(Slots updateSlot);
	
	public void deleteSlot(Slots idSlot);
	
	public List<Slots> listSlots();
	
	public List<Tuple> getDataSlots();
	
	public List<Slots> listSlotsTQ(); // listar con type query
	
	public Slots getById(int id);

}
