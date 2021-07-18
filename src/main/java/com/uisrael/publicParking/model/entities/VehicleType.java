package com.uisrael.publicParking.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_type")
public class VehicleType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVehicleType;
	
	private String vehicleType;
	
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkVehicleT")
	private List<Vehicle> lstVehicle = new ArrayList<Vehicle>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "fkRateHour")
	private RateHour fkRateHour;
	
	public List<Vehicle> getLstVehicle() {
		return lstVehicle;
	}

	public void setLstVehicle(List<Vehicle> lstVehicle) {
		this.lstVehicle = lstVehicle;
	}

	public RateHour getFkRateHour() {
		return fkRateHour;
	}

	public void setFkRateHour(RateHour fkRateHour) {
		this.fkRateHour = fkRateHour;
	}

	public int getIdVehicleType() {
		return idVehicleType;
	}

	public void setIdVehicleType(int idVehicleType) {
		this.idVehicleType = idVehicleType;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "VehicleType [idVehicleType=" + idVehicleType + ", vehicleType=" + vehicleType + "]";
	}
	
	
	
}
