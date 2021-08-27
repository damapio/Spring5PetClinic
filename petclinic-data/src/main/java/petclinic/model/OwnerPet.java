package petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "owners")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class OwnerPet extends Person {
	
	//Ja. @Builder no reconoce las properties heredadas: id, first and lastName.
	//Hay que ponerle constructores a todas. Paso, me parece una guarrada
//	@Builder
//    public OwnerPet(Long id, String firstName, String lastName, String address, String city,
//                 String telephone, Set<Pet> pets) {
//        super(id, firstName, lastName);
////        this.address = address;
////        this.city = city;
//        this.telephone = telephone;
//
//        if (null != pets) {
//            this.pets = pets;
//        }
//    }
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();
	
	@Column(name = "phone_number")
	private String telephone;

}
