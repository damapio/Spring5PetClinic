package petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import petclinic.model.OwnerPet;

public interface OwnerRepository extends CrudRepository<OwnerPet, Long> {
	
	OwnerPet findByLastName(String lastName);
}
