package com.uisrael.publicParking.view;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.component.datatable.DataTable;

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
	private List<RegisterParking> lstRegisterHistory;
	private float totalRecaudado=0;
	
	
	
	//para guardar datos del tipo vehiculo
	private String idVehicleTypeView = "";
	
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
	
	private String time;
	
	public RegisterParkingView() {}
	
	@PostConstruct
	public void init() {
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        time = sdfDate.format(now);
		
        
		
		slotsController = new SlotsControllerImpl();
		
		vehicleTypeController = new VehicleTypeControllerImpl();
		
		registerParkingController = new RegisterParkingControllerImpl();
		
		vehicleController = new VehicleControllerImpl();
		
		lstVehicle = new ArrayList<Vehicle>();
		
		lstSlots = new ArrayList<Slots>();
		
		listarSlots();
		
		listarVehiculos();
		
		listRegister();
		
		listarRegisterHistory();
		
		
	}
	
	public void getTotalRecaudadoPorDia() {
		
		totalRecaudado = 0;
		//totalRecaudado = registerParkingController.getTotalOfDayTQ(RegisterParking.AVAILABLE_REG, new Date());
		for (RegisterParking registerParking : lstRegisterHistory) {
			totalRecaudado += registerParking.getTotalRate();
		}
		
	}
	
	public void listarVehiculos() {
		
		lstVehicle = vehicleController.listVehicleTQ();
		
	}
	
	public void listRegister() {
		
		lstRegister = registerParkingController.listRegisterTQ(RegisterParking.NOT_AVAILABLE_REG);
	}
	
	public void listarRegisterHistory() {
		
		
		lstRegisterHistory = registerParkingController.listRegisterHistoryTQ(RegisterParking.AVAILABLE_REG, new Date());
		getTotalRecaudadoPorDia();
	}
	
	public void listarSlots() {
		
		lstSlots = slotsController.getSlotsByStatus(Slots.AVAILABLE_SLOT);
	}
	
	public void saveRegister() {
		
	
		
		//guaradar datos del vehiculo
		newVehicle = new Vehicle();
		newVehicle.setNumber(number);
		newVehicle.setBrand(brand);
		newVehicle.setColor(color);
		
		//obtener el ID del tipo de vehiculo
		VehicleType vehicleTypeId = vehicleTypeController.getVehicleTypeById(Integer.parseInt(idVehicleTypeView));
		newVehicle.setFkVehicleT(vehicleTypeId);
		newVehicle = vehicleController.createVehicle(newVehicle);
		
		//guardar datos del registro
		newRegister = new RegisterParking();
		//obtener el ID del Slot
		Slots slotId = slotsController.getById(Integer.parseInt(idSlots));
				
		//obtener el ID del vehiculo
		//Vehicle vehicleId = vehicleController.getVehicleById(Integer.parseInt(idVehicle));
		slotId.setStatusSlot(Slots.NOT_AVAILABLE_SLOT);
		slotsController.modifySlot(slotId);
				
		newRegister.setFkIdSlot(slotId);
		newRegister.setFkVehicle(newVehicle);
		newRegister.setStatusRegParking(RegisterParking.NOT_AVAILABLE_REG);
		newRegister.setTimeStart(new Timestamp(System.currentTimeMillis()));
		
		registerParkingController.createRegister(newRegister);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Añadido"));
		PrimeFaces.current().executeScript("PF('registerDialog').hide()");
		
		listRegister();
		listarSlots();
		clearFields();
		
		PrimeFaces.current().ajax().update("frmRegistros:allRegisters","frmRegistros:messages", "frmRegistros:historyReg", "frmRegistros:datosRegistro", "frmRegistros:datosSalida", "frmRegistros:pnlTotal");	
		
		
	}

	
	
	public void clearFields() {
		
		setIdVehicleTypeView (null);
		setNumber (null);
		setBrand (null);
		setColor (null);
		setIdSlots(null);
	
	}
	
	
	public void updateRegister() {
		
		selectedRegister.setStatusRegParking(RegisterParking.AVAILABLE_REG);
		registerParkingController.modifyRegister(selectedRegister);
		
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro de Salida"));
		PrimeFaces.current().executeScript("PF('registerUpdateDialog').hide()");
		//PrimeFaces.current().ajax().update("frmRegistros:allRegisters","frmRegistros:messages", "frmRegistros:historyReg");
		
		
		selectedRegister.getFkIdSlot().setStatusSlot(Slots.AVAILABLE_SLOT);
		slotsController.modifySlot(selectedRegister.getFkIdSlot());
		
		DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("frmRegistros:allRegisters");
		dataTable.reset();
			
		PrimeFaces.current().ajax().update("frmRegistros:allRegisters","frmRegistros:messages", "frmRegistros:historyReg", "frmRegistros:datosRegistro", "frmRegistros:datosSalida", "frmRegistros:pnlTotal");	

		
		
		listRegister();
		listarSlots();
		listarVehiculos();
		listarRegisterHistory();
		
		
	}
	
	public void calculateRate() {
		
		selectedRegister.setTimeEnd(new Timestamp(System.currentTimeMillis()));
		Timestamp startDate;
		Timestamp endDate;
		long differenceDate;
		int hours;
		int minutes;
		
		startDate = selectedRegister.getTimeStart();
		endDate = selectedRegister.getTimeEnd();
		
		differenceDate = endDate.getTime() - startDate.getTime();
		hours = (int) differenceDate/(3600*1000); 
		minutes = ((int) differenceDate/1000) % (3600/60);
		
		if(minutes > 0) {
			hours +=1;
			
		}
		selectedRegister.setTotalRate((float)hours*selectedRegister.getFkVehicle().getFkVehicleT().getFkRateHour().getPriceHour());
		
	}
	
	

	

	public float getTotalRecaudado() {
		return totalRecaudado;
	}

	public void setTotalRecaudado(float totalRecaudado) {
		this.totalRecaudado = totalRecaudado;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<RegisterParking> getLstRegisterHistory() {
		return lstRegisterHistory;
	}

	public void setLstRegisterHistory(List<RegisterParking> lstRegisterHistory) {
		this.lstRegisterHistory = lstRegisterHistory;
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

	public String getIdVehicleTypeView() {
		return idVehicleTypeView;
	}

	public void setIdVehicleTypeView(String idVehicleType) {
		this.idVehicleTypeView = idVehicleType;
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
