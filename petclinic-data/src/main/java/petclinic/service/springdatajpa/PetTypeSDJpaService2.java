package petclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import petclinic.model.PetType;
import petclinic.repositories.PetTypeRepository;
import petclinic.service.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService2 implements PetTypeService {
	
	private final PetTypeRepository petTypeRepository;
	
	public PetTypeSDJpaService2(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}
	
	@Override
	public Set<PetType> findAll() {
		Set<PetType> types = new HashSet<>();
		petTypeRepository.findAll().forEach(types::add);
		return types;
	}
	
	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}


	@Override
	public PetType save(PetType entity) {
		return petTypeRepository.save(entity);
	}

	@Override
	public void delete(PetType entity) {
		petTypeRepository.delete(entity);
		
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
		
	}
}
