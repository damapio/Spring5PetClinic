package petclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType type;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private OwnerPet owner;
	private LocalDate birthday;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits = new HashSet<>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public Set<Visit> getVisits() {
		return visits;
	}
	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
	
	

}
