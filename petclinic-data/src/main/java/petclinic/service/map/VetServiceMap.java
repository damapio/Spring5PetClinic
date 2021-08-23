package petclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import petclinic.model.Pet;
import petclinic.model.Vet;
import petclinic.model.VetSpeciality;
import petclinic.service.VetService;
import petclinic.service.VetSpecialityService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long>
	implements VetService {

	private final VetSpecialityService vetSpecialityService;
	
	public VetServiceMap(VetSpecialityService vetSpecialityService) {
		super();
		this.vetSpecialityService = vetSpecialityService;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet vet) {
		if (null != vet) {
			if (null == vet.getSpecialities()) {
				vet.getSpecialities().forEach(speciality -> {
					if (null == speciality.getId()) {
						VetSpeciality saved = vetSpecialityService.save(speciality);
						speciality.setId(saved.getId());
					}
				});
			}
			return super.save(vet);
		}
		return vet;
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet vet) {
		super.delete(vet);
	}

	
}
