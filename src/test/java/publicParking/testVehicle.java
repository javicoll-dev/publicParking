package publicParking;

import java.util.List;

import org.junit.Test;

import com.uisrael.publicParking.controller.VehicleController;
import com.uisrael.publicParking.controller.impl.VehicleControllerImpl;
import com.uisrael.publicParking.model.entities.RateHour;
import com.uisrael.publicParking.model.entities.Vehicle;
//import com.uisrael.publicParking.model.entities.VehicleType;

public class testVehicle {
	
	private VehicleController vehicleController;
	
	@Test
	public void test() {
		
		Vehicle newVehicle = new Vehicle();
		
		//VehicleType vehicleType = new VehicleType();
		//vehicleType.setIdVehicleType(2);
		
		RateHour rateHour = new RateHour();
		rateHour.setIdRateHour(2);
		
		newVehicle.setNumber("HJI2587");
		newVehicle.setBrand("Yamaha");
		newVehicle.setColor("Blanco");
		
		
		vehicleController = new VehicleControllerImpl();
		
		vehicleController.createVehicle(newVehicle);
		
		List<Vehicle> result = vehicleController.listVehicle();
		
		for(Vehicle tmp:result) {
			
			System.out.println("Vehiculo :"+ tmp);
		}
		
				
	}

}
