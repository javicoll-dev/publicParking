package com.uisrael.publicParking.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;


import com.uisrael.publicParking.controller.RateHourController;
import com.uisrael.publicParking.controller.impl.RateHourControllerImpl;
import com.uisrael.publicParking.model.entities.RateHour;

@ManagedBean
@ViewScoped
public class RateHourView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Float priceHour = (float) 0.0;
	private Date daterateHour;
	private RateHour newRateHour;
	private RateHour selectedRate;
	
	private RateHourController rateHController;
	private List<RateHour> lstRate;
	
	public RateHourView() {
				
	}
	
	
	@PostConstruct
	public void init() {
		clearFields();
		rateHController = new RateHourControllerImpl();
		lstRate = new ArrayList<RateHour>();
		daterateHour = new Date();
		
		selectedRate = new RateHour();
				
		
		listDataRate();
	}
	
	public void saveRate() {
		
		if(selectedRate.getIdRateHour() == 0) {
			
			newRateHour = new RateHour();
			
			newRateHour.setPriceHour(priceHour);
			newRateHour.setDaterateHour(daterateHour);
			
			rateHController.createRate(newRateHour);
					
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Añadido"));
			PrimeFaces.current().executeScript("PF('rateDialog').hide()");
			
		}
		else
		{
			rateHController.modifyRate(selectedRate);
			selectedRate = new RateHour();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro actualizado"));
			PrimeFaces.current().executeScript("PF('rateDialogActualiza').hide()");
			
			
			
		}
			
		
		listDataRate();
		
		clearFields();
		PrimeFaces.current().ajax().update("frmRates:rates","frmRates:messages");
		
	}
	
	public void clearFields() {
		setPriceHour ((float) 0.0);
		//setDaterateHour(null);
	
	}
	
	
	
	public void listDataRate() {
		
		lstRate = rateHController.listRateTQ();
		
	}

	
	public void deleteRate() {
		
		rateHController.deleteRate(selectedRate);
		selectedRate = new RateHour();
		listDataRate();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado"));
		PrimeFaces.current().ajax().update("frmRates:rates","frmRates:messages");
		
				
	}
	
	
	public RateHour getSelectedRate() {
		return selectedRate;
	}


	public void setSelectedRate(RateHour selectedRate) {
		this.selectedRate = selectedRate;
	}


	public Float getPriceHour() {
		return priceHour;
	}

	public void setPriceHour(Float priceHour) {
		this.priceHour = priceHour;
	}

	public RateHour getNewRateHour() {
		return newRateHour;
	}

	public void setNewRateHour(RateHour newRateHour) {
		this.newRateHour = newRateHour;
	}

	public RateHourController getRateHController() {
		return rateHController;
	}

	public void setRateHController(RateHourController rateHController) {
		this.rateHController = rateHController;
	}

	public List<RateHour> getLstRate() {
		return lstRate;
	}

	public void setLstRate(List<RateHour> lstRate) {
		this.lstRate = lstRate;
	}


	public Date getDaterateHour() {
		return daterateHour;
	}


	public void setDaterateHour(Date daterateHour) {
		this.daterateHour = daterateHour;
	}


	
	
	

}
