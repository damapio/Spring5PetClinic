package petclinic.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import petclinic.model.PetType;
import petclinic.service.PetTypeService;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<PetType, Long>
	implements PetTypeService {

	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}

	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}

	@Override
	public PetType save(PetType pet) {
		return super.save(pet);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(PetType pet) {
		super.delete(pet);
	}
	


}
