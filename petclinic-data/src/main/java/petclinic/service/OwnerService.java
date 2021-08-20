package petclinic.service;

import petclinic.model.OwnerPet;

public interface OwnerService extends CrudService<OwnerPet, Long>{

	OwnerPet findByLastName(String lastName);
	
}
