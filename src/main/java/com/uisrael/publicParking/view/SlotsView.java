package com.uisrael.publicParking.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.uisrael.publicParking.controller.SlotsController;
import com.uisrael.publicParking.controller.impl.SlotsControllerImpl;
import com.uisrael.publicParking.model.entities.Slots;

@ManagedBean
@ViewScoped
public class SlotsView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int statusSlot=0;//0 desocupado - 1 ocupado
	private String nameSLot;
	private Slots newSlot;
	private Slots selectedSlot;
	
	private SlotsController slotsController;
	private List<Slots> lstSlots;
	
	public SlotsView() {}
	
	@PostConstruct
	public void init() {
		
		slotsController = new SlotsControllerImpl();
		lstSlots = new ArrayList<Slots>();
		
		selectedSlot = new Slots();
		listDataSlot();
	}
	
	
	public void saveSlot() {
		
		newSlot = new Slots();
		newSlot.setNameSLot(nameSLot);
		newSlot.setStatusSlot(statusSlot);
		
		slotsController.createSlot(newSlot);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Añadido"));
		PrimeFaces.current().executeScript("PF('slotDialog').hide()");
		
		listDataSlot();
		
		PrimeFaces.current().ajax().update("frmSlots:slotsTable","frmSlots:messages");
		
		clearFields();
	}
	
	public void listDataSlot() {
		
		lstSlots = slotsController.listSlotsTQ();
		
	}
	
	public void deleteSlot() {
		
		slotsController.deleteSlot(selectedSlot);
		selectedSlot = new Slots();
		listDataSlot();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado"));
		PrimeFaces.current().ajax().update("frmSlots:slotsTable","frmSlots:messages");
	}
	
	public void clearFields() {
		setNameSLot(null);
	}

	public String getNameSLot() {
		return nameSLot;
	}

	public void setNameSLot(String nameSLot) {
		this.nameSLot = nameSLot;
	}

	public int getStatusSlot() {
		return statusSlot;
	}

	public void setStatusSlot(int statusSlot) {
		this.statusSlot = statusSlot;
	}

	public Slots getNewSlot() {
		return newSlot;
	}

	public void setNewSlot(Slots newSlot) {
		this.newSlot = newSlot;
	}

	public Slots getSelectedSlot() {
		return selectedSlot;
	}

	public void setSelectedSlot(Slots selectedSlot) {
		this.selectedSlot = selectedSlot;
	}

	public SlotsController getSlotsController() {
		return slotsController;
	}

	public void setSlotsController(SlotsController slotsController) {
		this.slotsController = slotsController;
	}

	public List<Slots> getLstSlots() {
		return lstSlots;
	}

	public void setLstSlots(List<Slots> lstSlots) {
		this.lstSlots = lstSlots;
	}
	
	
}
