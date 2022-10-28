package hassan.essadik.cars_lease.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long>{
	List<Car> findByInUse(boolean inUse);
	List<Car> findByColor(String color);
	List<Car> findByBrandContaining(String brand);
	
}
