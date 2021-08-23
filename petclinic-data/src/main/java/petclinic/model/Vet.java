package petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

	private Set<VetSpeciality> specialities = new HashSet<>();

	public Set<VetSpeciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<VetSpeciality> specialties) {
		this.specialities = specialties;
	}
	
	
}
