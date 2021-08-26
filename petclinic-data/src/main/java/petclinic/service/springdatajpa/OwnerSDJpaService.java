package petclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import petclinic.model.OwnerPet;
import petclinic.repositories.OwnerRepository;
import petclinic.service.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
	
	private final OwnerRepository ownerRepository;
	
	public OwnerSDJpaService(OwnerRepository ownerRepository) {
		super();
		this.ownerRepository = ownerRepository;
	}
	
	@Override
	public Set<OwnerPet> findAll() {
		Set<OwnerPet> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}
	
	@Override
	public OwnerPet findById(Long id) {
//		Optional<OwnerPet> optionalOwner = ownerRepository.findById(id);
//		if (optionalOwner.isPresent()) {
//			return optionalOwner.get();
//		} else {
//			return null;
//		}
		return ownerRepository.findById(id).orElse(null);
	}
	
	@Override
	public OwnerPet findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}


	@Override
	public OwnerPet save(OwnerPet entity) {
		return ownerRepository.save(entity);
	}



	@Override
	public void delete(OwnerPet entity) {
		ownerRepository.delete(entity);
		
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
		
	}
}
