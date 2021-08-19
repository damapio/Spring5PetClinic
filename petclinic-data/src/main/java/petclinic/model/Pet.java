package petclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {
	
	private PetType type;
	private OwnerPet owner;
	private LocalDate birthday;
	
	
	public PetType getType() {
		return type;
	}
	public void setType(PetType type) {
		this.type = type;
	}
	public OwnerPet getOwner() {
		return owner;
	}
	public void setOwner(OwnerPet owner) {
		this.owner = owner;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	

}
