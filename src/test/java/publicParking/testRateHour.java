package publicParking;

import java.util.List;

import org.junit.Test;

import com.uisrael.publicParking.controller.RateHourController;
import com.uisrael.publicParking.controller.impl.RateHourControllerImpl;
import com.uisrael.publicParking.model.entities.RateHour;

public class testRateHour {
	
	private RateHourController rateHourController;
	
	@Test
	public void test() {
		
		RateHour newRate = new RateHour();
		
		
		newRate.setPriceHour(1.50f);
		
		rateHourController = new RateHourControllerImpl();
		
		rateHourController.createRate(newRate);
		
		List<RateHour> result = rateHourController.listRate();
		
		for(RateHour tmp:result) {
			
			System.out.println("Rate hour: " + tmp);
		}
		
	}

}
