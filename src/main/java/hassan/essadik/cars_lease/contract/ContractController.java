package hassan.essadik.cars_lease.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hassan.essadik.cars_lease.car.Car;

@RestController
@RequestMapping("/api/v1/contracts")
public class ContractController {
	@Autowired
	ContractService contractService;
	
	@GetMapping("/")
	public List<Contract> listContract(){
		return contractService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contract> getContractById(@PathVariable("id") long id){
		Contract contract = contractService.getById(id);

		if (contract != null)
			return new ResponseEntity<>(contract,HttpStatus.OK);
		else
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/")
	public ResponseEntity<Contract> createCar(@RequestBody Contract contract) {
		try {
			Contract createdContract = contractService.save(contract);
			return new ResponseEntity<>(createdContract, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
}
