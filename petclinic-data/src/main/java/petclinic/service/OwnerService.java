package petclinic.service;

import java.util.Set;

import petclinic.model.OwnerPet;

public interface OwnerService {

	OwnerPet findByLastName(String lastName);
	
	OwnerPet findById(Long id);
	
	OwnerPet save(OwnerPet owner);
	
	Set<OwnerPet> findAll();
	
}
