package hassan.essadik.cars_lease;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hassan.essadik.cars_lease.car.CarService;
import hassan.essadik.cars_lease.contract.ContractService;

@SpringBootApplication
public class CarsLeaseApplication{
	@Autowired
	CarService carService;
	
	@Autowired
	ContractService contractService;
	
	public static void main(String[] args) {
		SpringApplication.run(CarsLeaseApplication.class, args);
	}
}
