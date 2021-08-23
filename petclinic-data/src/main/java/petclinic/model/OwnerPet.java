package petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class OwnerPet extends Person {
	
	private Set<Pet> pets = new HashSet<>();
	private String telephone;

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	

}
