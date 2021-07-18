package com.uisrael.publicParking.model.entities;

import java.io.Serializable;
import java.sql.Timestamp;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "register_parking")
public class RegisterParking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRegisterParking;
	
	private Timestamp timeStart;
	
	private Timestamp timeEnd;	
		
	
	//@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	//@JoinColumn(name = "fkClient")
	//private Client fkClient;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "fkVehicle")
	private Vehicle fkVehicle;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "fkIdSlot")
	private Slots fkIdSlot;


	public int getIdRegisterParking() {
		return idRegisterParking;
	}


	public void setIdRegisterParking(int idRegisterParking) {
		this.idRegisterParking = idRegisterParking;
	}


	
	public Timestamp getTimeStart() {
		return timeStart;
	}


	public void setTimeStart(Timestamp timeStart) {
		this.timeStart = timeStart;
	}


	public Timestamp getTimeEnd() {
		return timeEnd;
	}


	public void setTimeEnd(Timestamp timeEnd) {
		this.timeEnd = timeEnd;
	}


	/*public Client getFkClient() {
		return fkClient;
	}


	public void setFkClient(Client fkClient) {
		this.fkClient = fkClient;
	}*/


	public Slots getFkIdSlot() {
		return fkIdSlot;
	}


	public void setFkIdSlot(Slots fkIdSlot) {
		this.fkIdSlot = fkIdSlot;
	}


	public Vehicle getFkVehicle() {
		return fkVehicle;
	}


	public void setFkVehicle(Vehicle fkVehicle) {
		this.fkVehicle = fkVehicle;
	}


	@Override
	public String toString() {
		return "RegisterParking [idRegisterParking=" + idRegisterParking + ", timeStart=" + timeStart + ", timeEnd="
				+ timeEnd + ", fkVehicle=" + fkVehicle + ", fkIdSlot=" + fkIdSlot + "]";
	}


	

	
	
		
}
