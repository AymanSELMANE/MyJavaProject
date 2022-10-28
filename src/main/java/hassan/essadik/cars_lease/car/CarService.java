package hassan.essadik.cars_lease.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	@Autowired
	CarRepository carRepository; 
	//carRepository = new Hibernate();
	
	public Car save(Car car) {
		return carRepository.save(car);
	} 
	
	public List<Car> getAll(){
		return carRepository.findAll();
	}
	
	public Car getById(long id) {
		return carRepository.findById(id).orElse(null);
	}
	
	public List<Car> getByColor(String color){
		return carRepository.findByColor(color);
	}
	
	public List<Car> getByBrandC(String brand){
		return carRepository.findByBrandContaining(brand);
	}
	
	public boolean deleteById(long id) {
		try {
			carRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
