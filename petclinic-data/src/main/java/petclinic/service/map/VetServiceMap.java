package petclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import petclinic.model.Vet;
import petclinic.service.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long>
	implements VetService {

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Long id, Vet vet) {
		return super.save(id, vet);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet vet) {
		super.delete(vet);
	}

	@Override
	public Vet save(Vet vet) {
		return super.save(vet.getId(), vet);
	}
	


}
