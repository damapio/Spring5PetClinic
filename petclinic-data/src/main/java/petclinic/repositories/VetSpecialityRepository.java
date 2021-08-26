package petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import petclinic.model.Vet;

public interface VetSpecialityRepository extends CrudRepository<Vet, Long>{

}
