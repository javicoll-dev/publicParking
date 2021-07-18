package com.uisrael.publicParking.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVehicle;
	
	private String number;
	private String brand;
	private String color;
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkVehicle")
	//private List<Client> lstClient = new ArrayList<Client>();
	private List<RegisterParking> lstRegisterP = new ArrayList<RegisterParking>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "fkVehicleT")
	private VehicleType fkVehicleT;
	
		
	/*public List<Client> getLstClient() {
		return lstClient;
	}
	public void setLstClient(List<Client> lstClient) {
		this.lstClient = lstClient;
	}*/
	
	public int getIdVehicle() {
		return idVehicle;
	}
	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
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
	public VehicleType getFkVehicleT() {
		return fkVehicleT;
	}
	public void setFkVehicleT(VehicleType fkVehicleT) {
		this.fkVehicleT = fkVehicleT;
	}
	public List<RegisterParking> getLstRegisterP() {
		return lstRegisterP;
	}
	public void setLstRegisterP(List<RegisterParking> lstRegisterP) {
		this.lstRegisterP = lstRegisterP;
	}
	@Override
	public String toString() {
		return "Vehicle [idVehicle=" + idVehicle + ", number=" + number + ", brand=" + brand + ", color=" + color
				+ ", lstRegisterP=" + lstRegisterP + ", fkVehicleT=" + fkVehicleT + "]";
	}
	
	
	
	
	
	
	
}
