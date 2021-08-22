package petclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import petclinic.model.OwnerPet;
import petclinic.service.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<OwnerPet, Long>
	implements OwnerService {

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

	@Override
	public OwnerPet findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
