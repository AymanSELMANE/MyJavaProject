package hassan.essadik.cars_lease.option;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OptionService {
	@Autowired
	OptionRepository optionRepository;
	
	public Option save(Option option) {
		return optionRepository.save(option);
	}
	
	public List<Option> getAll(){
		return optionRepository.findAll();
	}
	
	public Option getById(long id) {
		return optionRepository.findById(id).orElse(null);
	}
	
	public void deleteById(long id) {
		optionRepository.deleteById(id);
	}
	
}
