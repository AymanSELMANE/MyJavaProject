package hassan.essadik.cars_lease.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;
	
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	
	public List<Client> getAll(){
		return clientRepository.findAll();
	}
	
	public Client getById(long id) {
		return clientRepository.findById(id).orElse(null);
	}
	
	public Client deleteById(long id) {
		return clientRepository.deleteById(id);
	}
	
	public void deleteAll() {
		clientRepository.deleteAll();
	}
	
	public List<Client> getByFnameAndLname(String Fname, String Lname){
		return clientRepository.findByFnameAndLname(Fname, Lname);
	}
	
}
