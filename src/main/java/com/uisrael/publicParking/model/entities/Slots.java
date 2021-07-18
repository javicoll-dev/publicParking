package com.uisrael.publicParking.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "slots")
public class Slots implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSlot;
	private String nameSLot;
	private int statusSlot;
	
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkIdSlot")
	private List<RegisterParking> lstRegisterP = new ArrayList<RegisterParking>();

	
		public String getNameSLot() {
		return nameSLot;
	}


	public void setNameSLot(String nameSLot) {
		this.nameSLot = nameSLot;
	}


	public int getIdSlot() {
		return idSlot;
	}


	public void setIdSlot(int idSlot) {
		this.idSlot = idSlot;
	}


	public int getStatusSlot() {
		return statusSlot;
	}


	public void setStatusSlot(int statusSlot) {
		this.statusSlot = statusSlot;
	}


	public List<RegisterParking> getLstRegisterP() {
		return lstRegisterP;
	}


	public void setLstRegisterP(List<RegisterParking> lstRegisterP) {
		this.lstRegisterP = lstRegisterP;
	}


	@Override
	public String toString() {
		return "Slots [idSlot=" + idSlot + ", statusSlot=" + statusSlot + ", lstRegisterP=" + lstRegisterP + "]";
	}
	
	
	
}
