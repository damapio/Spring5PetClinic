package petclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Person extends BaseEntity {

	@Column(name = "first_name") //aunque Hibernate defaults a esto mismo
	private String firstName;
	private String lastName;
	
}
