package com.uisrael.publicParking.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.uisrael.publicParking.controller.VehicleController;
import com.uisrael.publicParking.controller.impl.VehicleControllerImpl;
import com.uisrael.publicParking.model.entities.Vehicle;


@ManagedBean
@ViewScoped
public class VehicleView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String number;
	private String brand;
	private String color;
	
	private VehicleController vehicleController;
	private List<Vehicle> lstVehicle;
	
	public VehicleView () {
				
	}
	
	@PostConstruct
	public void init() {
		
		vehicleController = new VehicleControllerImpl();
		lstVehicle = new ArrayList<Vehicle>();
		listarVehiculos();
	}
	
	public void updateTable() {
		
		listarVehiculos();
		
	}
	
	
	public void listarVehiculos() {
		
		lstVehicle = vehicleController.listVehicle();
		
	}

	public VehicleController getVehicleController() {
		return vehicleController;
	}

	public void setVehicleController(VehicleController vehicleController) {
		this.vehicleController = vehicleController;
	}

	public List<Vehicle> getLstVehicle() {
		return lstVehicle;
	}

	public void setLstVehicle(List<Vehicle> lstVehicle) {
		this.lstVehicle = lstVehicle;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
	
}
