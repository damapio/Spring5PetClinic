package petclinic.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import petclinic.model.OwnerPet;
import petclinic.model.Pet;
import petclinic.model.Visit;
import petclinic.service.PetService;
import petclinic.service.PetTypeService;
import petclinic.service.VisitService;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long>
	implements VisitService {
	
	private final PetTypeService petTypeService;
	private final PetService petService;
	
	public VisitServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	
	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit visit) {
		if (null == visit.getPet() || null == visit.getPet().getId() ||
			null == visit.getPet().getOwner() || null == visit.getPet().getOwner().getId()) {
			throw new RuntimeException("Incomplete visit details");
		}
		return super.save(visit);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Visit visit) {
		super.delete(visit);
	}

}
