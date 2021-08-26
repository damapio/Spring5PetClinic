package petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends Person {

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialities", 
				joinColumns = @JoinColumn(name = "vet_id"),
				inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<VetSpeciality> specialities = new HashSet<>();

	public Set<VetSpeciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<VetSpeciality> specialties) {
		this.specialities = specialties;
	}
	
	
}
