package petclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import petclinic.model.Vet;
import petclinic.model.VetSpeciality;
import petclinic.repositories.VetSpecialityRepository;
import petclinic.service.VetSpecialityService;

@Service
@Profile("springdatajpa")
public class VetSpecialitySDJpaService implements VetSpecialityService {
	
	private final VetSpecialityRepository vetSpecialityRepository;
	
	public VetSpecialitySDJpaService(VetSpecialityRepository vetSpecialityRepository) {
		super();
		this.vetSpecialityRepository = vetSpecialityRepository;
	}
	
	@Override
	public Set<VetSpeciality> findAll() {
		Set<VetSpeciality> specialities = new HashSet<>();
		vetSpecialityRepository.findAll().forEach(specialities::add);
		return specialities;
	}
	
	@Override
	public VetSpeciality findById(Long id) {
		return vetSpecialityRepository.findById(id).orElse(null);
	}


	@Override
	public VetSpeciality save(VetSpeciality entity) {
		return vetSpecialityRepository.save(entity);
	}

	@Override
	public void delete(VetSpeciality entity) {
		vetSpecialityRepository.delete(entity);
		
	}

	@Override
	public void deleteById(Long id) {
		vetSpecialityRepository.deleteById(id);
		
	}
}
