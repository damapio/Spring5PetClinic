package petclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import petclinic.model.Visit;
import petclinic.repositories.VisitRepository;
import petclinic.service.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {
	
	private final VisitRepository visitRepository;
	
	public VisitSDJpaService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}
	
	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}
	
	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}


	@Override
	public Visit save(Visit entity) {
		return visitRepository.save(entity);
	}



	@Override
	public void delete(Visit entity) {
		visitRepository.delete(entity);
		
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
		
	}
}
