package petclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import petclinic.model.OwnerPet;
import petclinic.model.Pet;
import petclinic.service.OwnerService;
import petclinic.service.PetService;
import petclinic.service.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractMapService<OwnerPet, Long>
	implements OwnerService {
	
	private final PetTypeService petTypeService;
	private final PetService petService;
	
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	
	@Override
	public Set<OwnerPet> findAll() {
		return super.findAll();
	}

	@Override
	public OwnerPet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public OwnerPet save(OwnerPet owner) {
		if (null != owner) {
			if (null != owner.getPets()) {
				owner.getPets().forEach(pet -> {
					if (null != pet.getType()) {
						if (null == pet.getType().getId()) {
							pet.setType(petTypeService.save(pet.getType()));
						}
					}
					if (null == pet.getId()) {
						Pet saved = petService.save(pet);
						pet.setId(saved.getId());
					}
				});
			}
			return super.save(owner);
		}
		return owner;
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(OwnerPet owner) {
		super.delete(owner);
	}

	@Override
	public OwnerPet findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
