package petclinic.service.map;

import java.util.Set;

import petclinic.model.OwnerPet;
import petclinic.service.CrudService;

public class OwnerServiceMap extends AbstractMapService<OwnerPet, Long>
	implements CrudService<OwnerPet, Long> {

	@Override
	public Set<OwnerPet> findAll() {
		return super.findAll();
	}

	@Override
	public OwnerPet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public OwnerPet save(Long id, OwnerPet owner) {
		return super.save(id, owner);
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
	public OwnerPet save(OwnerPet owner) {
		return super.save(owner.getId(), owner);
	}
	


}
