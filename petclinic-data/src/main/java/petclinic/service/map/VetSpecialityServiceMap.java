package petclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import petclinic.model.VetSpeciality;
import petclinic.service.VetSpecialityService;

@Service
public class VetSpecialityServiceMap extends AbstractMapService<VetSpeciality, Long>
	implements VetSpecialityService {

	@Override
	public Set<VetSpeciality> findAll() {
		return super.findAll();
	}

	@Override
	public VetSpeciality findById(Long id) {
		return super.findById(id);
	}

	@Override
	public VetSpeciality save(VetSpeciality vet) {
		return super.save(vet);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(VetSpeciality vet) {
		super.delete(vet);
	}

	
}
