package com.uisrael.publicParking.view;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



import com.uisrael.publicParking.controller.RegisterParkingController;
import com.uisrael.publicParking.controller.SlotsController;
import com.uisrael.publicParking.controller.VehicleController;
import com.uisrael.publicParking.controller.VehicleTypeController;


import com.uisrael.publicParking.controller.impl.RegisterParkingControllerImpl;
import com.uisrael.publicParking.controller.impl.SlotsControllerImpl;
import com.uisrael.publicParking.controller.impl.VehicleControllerImpl;
import com.uisrael.publicParking.controller.impl.VehicleTypeControllerImpl;


import com.uisrael.publicParking.model.entities.RegisterParking;
import com.uisrael.publicParking.model.entities.Slots;
import com.uisrael.publicParking.model.entities.Vehicle;
import com.uisrael.publicParking.model.entities.VehicleType;


@ManagedBean
@ViewScoped
public class RegisterParkingView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//private String idRatehour;
	
	
	//para guardar los datos de la cabecera del registro

	private Timestamp timeStart;
	private Timestamp timeEnd;
	private RegisterParking newRegister;
	private RegisterParking selectedRegister;
	
	private RegisterParkingController registerParkingController;
	private List<RegisterParking> lstRegister;
	
	
	//para guardar datos del tipo vehiculo
	private String idVehicleType = "";
	
	private VehicleTypeController vehicleTypeController;
	
	//para guaradar datos del vehiculo
	private String idVehicle = "";
	private String number;
	private String brand;
	private String color;
	private Vehicle newVehicle;
	
	private VehicleController vehicleController;
	private List<Vehicle> lstVehicle;
	
	
	//para guardar datos del espacio
	private String idSlots = "";
	private SlotsController slotsController;
	private List<Slots> lstSlots;
	
	
	
	public RegisterParkingView() {}
	
	@PostConstruct
	public void init() {
		
		
		slotsController = new SlotsControllerImpl();
		
		vehicleTypeController = new VehicleTypeControllerImpl();
		
		registerParkingController = new RegisterParkingControllerImpl();
		
		vehicleController = new VehicleControllerImpl();
		
		lstVehicle = new ArrayList<Vehicle>();
		
		lstSlots = new ArrayList<Slots>();
		
		listarSlots();
		
		listarVehiculos();
		
		listRegister();
		
	}
	
	public void listarVehiculos() {
		
		lstVehicle = vehicleController.listVehicleTQ();
		
	}
	
	public void listarSlots() {
		
		lstSlots = slotsController.listSlotsTQ();
	}
	
	public void saveRegister() {
		
		//guaradar datos del vehiculo
		newVehicle = new Vehicle();
		newVehicle.setNumber(number);
		newVehicle.setBrand(brand);
		newVehicle.setColor(color);
		
		//obtener el ID del tipo de vehiculo
		VehicleType vehicleTypeId = vehicleTypeController.getVehicleTypeById(Integer.parseInt(idVehicleType));
		newVehicle.setFkVehicleT(vehicleTypeId);
		newVehicle = vehicleController.createVehicle(newVehicle);
		
		//guardar datos del registro
		newRegister = new RegisterParking();
		//obtener el ID del Slot
				Slots slotId = slotsController.getById(Integer.parseInt(idSlots));
				
		//obtener el ID del vehiculo
		Vehicle vehicleId = vehicleController.getVehicleById(Integer.parseInt(idVehicle));
		
		newRegister.setFkIdSlot(slotId);
		newRegister.setFkVehicle(vehicleId);
		newRegister.setTimeStart(new Timestamp(System.currentTimeMillis()));

		registerParkingController.createRegister(newRegister);
		
		listRegister();
		clearFields() ;
		
		
		
	}

	public void listRegister() {
		
		lstRegister = registerParkingController.listRegisterTQ();
	}
	
	public void clearFields() {
		
		setIdVehicleType (null);
		setNumber (null);
		setBrand (null);
		setColor (null);
		setIdSlots(null);
	
	}
	
	
	public void updateRegister() {
		
		selectedRegister.setTimeEnd(new Timestamp(System.currentTimeMillis()));
		
		registerParkingController.modifyRegister(selectedRegister);
		listRegister();
		
	}
	
	

	public String getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(String idVehicle) {
		this.idVehicle = idVehicle;
	}

	public List<Slots> getLstSlots() {
		return lstSlots;
	}

	public void setLstSlots(List<Slots> lstSlots) {
		this.lstSlots = lstSlots;
	}

	public String getIdSlots() {
		return idSlots;
	}

	public void setIdSlots(String idSlots) {
		this.idSlots = idSlots;
	}

	public SlotsController getSlotsController() {
		return slotsController;
	}

	public void setSlotsController(SlotsController slotsController) {
		this.slotsController = slotsController;
	}

	public RegisterParking getSelectedRegister() {
		return selectedRegister;
	}

	public void setSelectedRegister(RegisterParking selectedRegister) {
		this.selectedRegister = selectedRegister;
	}

	public RegisterParkingController getRegisterParkingController() {
		return registerParkingController;
	}

	public void setRegisterParkingController(RegisterParkingController registerParkingController) {
		this.registerParkingController = registerParkingController;
	}

	public List<RegisterParking> getLstRegister() {
		return lstRegister;
	}

	public void setLstRegister(List<RegisterParking> lstRegister) {
		this.lstRegister = lstRegister;
	}

	public String getIdVehicleType() {
		return idVehicleType;
	}

	public void setIdVehicleType(String idVehicleType) {
		this.idVehicleType = idVehicleType;
	}

	public VehicleTypeController getVehicleTypeController() {
		return vehicleTypeController;
	}

	public void setVehicleTypeController(VehicleTypeController vehicleTypeController) {
		this.vehicleTypeController = vehicleTypeController;
	}

	

	public Date getTimeStart() {
		return timeStart;
	}

	

	public RegisterParking getNewRegister() {
		return newRegister;
	}

	public void setNewRegister(RegisterParking newRegister) {
		this.newRegister = newRegister;
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

	public Vehicle getNewVehicle() {
		return newVehicle;
	}

	public void setNewVehicle(Vehicle newVehicle) {
		this.newVehicle = newVehicle;
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

	/*public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Client getNewClient() {
		return newClient;
	}

	public void setNewClient(Client newClient) {
		this.newClient = newClient;
	}

	public ClientController getClientController() {
		return clientController;
	}

	public void setClientController(ClientController clientController) {
		this.clientController = clientController;
	}

	public List<Client> getLstClient() {
		return lstClient;
	}

	public void setLstClient(List<Client> lstClient) {
		this.lstClient = lstClient;
	}*/

	public Timestamp getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Timestamp timeEnd) {
		this.timeEnd = timeEnd;
	}

	

	public void setTimeStart(Timestamp timeStart) {
		this.timeStart = timeStart;
	}

	
	
}
