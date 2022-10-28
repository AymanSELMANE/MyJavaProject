package hassan.essadik.cars_lease.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{
	Client deleteById(long id);
	//long deleteById(long id);
	List<Client> findByFnameAndLname(String fname, String lname);
}
