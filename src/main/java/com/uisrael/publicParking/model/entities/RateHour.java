package com.uisrael.publicParking.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rate_hour")
public class RateHour implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idRateHour;
	private Date daterateHour;
	private Float priceHour;
	
	
	
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkRateHour")
	private List<VehicleType> lstVehicleT = new ArrayList<VehicleType>();
	

	public int getIdRateHour() {
		return idRateHour;
	}

	public void setIdRateHour(int idRateHour) {
		this.idRateHour = idRateHour;
	}

	public Float getPriceHour() {
		return priceHour;
	}

	public void setPriceHour(Float priceHour) {
		this.priceHour = priceHour;
	}

	

	public List<VehicleType> getLstVehicleT() {
		return lstVehicleT;
	}

	public void setLstVehicleT(List<VehicleType> lstVehicleT) {
		this.lstVehicleT = lstVehicleT;
	}

	public Date getDaterateHour() {
		return daterateHour;
	}

	public void setDaterateHour(Date daterateHour) {
		this.daterateHour = daterateHour;
	}

	@Override
	public String toString() {
		return "RateHour [idRateHour=" + idRateHour + ", daterateHour=" + daterateHour + ", priceHour=" + priceHour
				+ ", lstVehicleT=" + lstVehicleT + "]";
	}

	

	

	
	
}
