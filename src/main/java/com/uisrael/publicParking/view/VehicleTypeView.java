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

import com.uisrael.publicParking.controller.RateHourController;
import com.uisrael.publicParking.controller.VehicleTypeController;
import com.uisrael.publicParking.controller.impl.RateHourControllerImpl;
import com.uisrael.publicParking.controller.impl.VehicleTypeControllerImpl;
import com.uisrael.publicParking.model.entities.RateHour;
import com.uisrael.publicParking.model.entities.VehicleType;


@ManagedBean
@ViewScoped
public class VehicleTypeView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int variableVT;
	private int variableVT2;
	private String vehicleType;
	private VehicleType newVehicleType;
	
	private VehicleType selectedVehicleT;
	
	private VehicleTypeController vehicleTypeController;
	private List<VehicleType> lstVehicleType;
	
	private RateHourController rateHourController;
	
	public VehicleTypeView() {}
	
	@PostConstruct
	public void init() {
		
		vehicleTypeController = new VehicleTypeControllerImpl();
		rateHourController = new RateHourControllerImpl();
		lstVehicleType = new ArrayList<VehicleType>();
	
		selectedVehicleT = new VehicleType();

		listDataVehicleType();
		clearFields();
	}
	
	
	
	public void saveVehicleType() {
		
		RateHour rateHourId = rateHourController.getRateHourById(variableVT);
		
				
			newVehicleType = new VehicleType();
			newVehicleType.setVehicleType(vehicleType);
			newVehicleType.setFkRateHour(rateHourId);
			
			vehicleTypeController.createVehicleT(newVehicleType);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Añadido"));
			PrimeFaces.current().executeScript("PF('vehicleTDialog').hide()");
			
			
		
		listDataVehicleType();
		clearFields();
		
		PrimeFaces.current().ajax().update("frmVT:vehicleType","frmVT:messages");
		
		newVehicleType = new VehicleType();	
		
	}
	
	public void listDataVehicleType() {
		
		lstVehicleType = vehicleTypeController.listVehicleTTQ();
		
	}
	
	public void clearFields() {
		setVehicleType (null);
		setVariableVT(0);
		//setIdRateHour (null);
		
	
	}

	
	public void updateVehicleType() {
		
		RateHour rateHourIdUpdate = rateHourController.getRateHourById(variableVT2);
		//RateHour rateHourIdUpdate = rateHourController.getRateHourById((idRateHour));
		selectedVehicleT.setFkRateHour(rateHourIdUpdate);
		
		vehicleTypeController.modifyVehicleT(selectedVehicleT);
		selectedVehicleT = new VehicleType();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Actualizado"));
		PrimeFaces.current().executeScript("PF('vehicleTDialogActualiza').hide()");
		listDataVehicleType();
		
		PrimeFaces.current().ajax().update("frmVT:vehicleType","frmVT:messages");
	}
	
	public void deleteVehicleType() {
		
		vehicleTypeController.deleteVehicleT(selectedVehicleT);
		selectedVehicleT = new VehicleType();
		listDataVehicleType();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado"));
		PrimeFaces.current().ajax().update("frmVT:vehicleType","frmVT:messages");
		
	}

	
	
	public int getVariableVT2() {
		return variableVT2;
	}



	public void setVariableVT2(int variableVT2) {
		this.variableVT2 = variableVT2;
	}



	public int getVariableVT() {
		return variableVT;
	}


	public void setVariableVT(int variableVT) {
		this.variableVT = variableVT;
	}


	public VehicleType getSelectedVehicleT() {
		return selectedVehicleT;
	}


	public void setSelectedVehicleT(VehicleType selectedVehicleT) {
		this.selectedVehicleT = selectedVehicleT;
	}


	public RateHourController getRateHourController() {
		return rateHourController;
	}


	public void setRateHourController(RateHourController rateHourController) {
		this.rateHourController = rateHourController;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public VehicleType getNewVehicleType() {
		return newVehicleType;
	}


	public void setNewVehicleType(VehicleType newVehicleType) {
		this.newVehicleType = newVehicleType;
	}


	public VehicleTypeController getVehicleTypeController() {
		return vehicleTypeController;
	}


	public void setVehicleTypeController(VehicleTypeController vehicleTypeController) {
		this.vehicleTypeController = vehicleTypeController;
	}


	public List<VehicleType> getLstVehicleType() {
		return lstVehicleType;
	}


	public void setLstVehicleType(List<VehicleType> lstVehicleType) {
		this.lstVehicleType = lstVehicleType;
	}


	/*public int getIdRateHour() {
		return idRateHour;
	}


	public void setIdRateHour(int idRateHour) {
		this.idRateHour = idRateHour;
	}*/


	
	


	

	
}
