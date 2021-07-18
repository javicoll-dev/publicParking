package com.uisrael.publicParking.controller.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.publicParking.controller.SlotsController;

import com.uisrael.publicParking.model.dao.impl.SlotsDaoImpl;
import com.uisrael.publicParking.model.entities.Slots;

public class SlotsControllerImpl implements SlotsController{

	private SlotsDaoImpl slotDao;
	
	public SlotsControllerImpl() {
		
		slotDao = new SlotsDaoImpl();
	}
	
	@Override
	public void createSlot(Slots newSlot) {

		slotDao.createSlot(newSlot);	
	}

	@Override
	public void modifySlot(Slots updateSlot) {
		slotDao.modifySlot(updateSlot);
		
	}

	@Override
	public void deleteSlot(Slots idSlot) {
		slotDao.deleteSlot(idSlot);
		
	}

	@Override
	public List<Slots> listSlots() {
		return slotDao.listSlots();
	}

	@Override
	public List<Tuple> getDataSlots() {
		
		return slotDao.getDataSlots();
	}

	@Override
	public List<Slots> listSlotsTQ() {
		
		return slotDao.listSlotsTQ();
	}

	@Override
	public Slots getById(int id) {
		
		return slotDao.getById(id);
	}

}
