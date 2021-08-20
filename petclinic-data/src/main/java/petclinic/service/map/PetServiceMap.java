package petclinic.service.map;

import java.util.Set;

import petclinic.model.Pet;
import petclinic.service.CrudService;

public class PetServiceMap extends AbstractMapService<Pet, Long>
	implements CrudService<Pet, Long> {

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Long id, Pet pet) {
		return super.save(id, pet);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Pet pet) {
		super.delete(pet);
	}

	@Override
	public Pet save(Pet pet) {
		return super.save(pet.getId(), pet);
	}
	


}