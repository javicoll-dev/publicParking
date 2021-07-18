package publicParking;

//import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.uisrael.publicParking.controller.RegisterParkingController;
import com.uisrael.publicParking.controller.impl.RegisterParkingControllerImpl;
//import com.uisrael.publicParking.model.entities.Client;
import com.uisrael.publicParking.model.entities.RegisterParking;

public class testRegister {
	
	private RegisterParkingController registerController;
	
	@Test
	public void test() {
		
		//Date objDate = new Date(); 
		
		//Client clientRegister = new Client();
		//clientRegister.setIdCliente(1);
		
		RegisterParking newRegister = new RegisterParking();
		//newRegister.setRegisterDate(objDate);
		/*newRegister.setTimeStart(objDate);
		newRegister.setTimeEnd(objDate);
		newRegister.setComment("Sin novedades");
		newRegister.setFkClient(clientRegister);*/
		registerController = new RegisterParkingControllerImpl();
		
		registerController.createRegister(newRegister);
		
		List<RegisterParking> result = registerController.listRegisterTQ();
		
		for(RegisterParking tmp:result) {
			
			System.out.println("Registros :"+ tmp);
		}
	
	}

}
