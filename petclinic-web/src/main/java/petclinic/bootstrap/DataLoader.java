package petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import petclinic.model.OwnerPet;
import petclinic.model.Vet;
import petclinic.service.OwnerService;
import petclinic.service.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	

	public DataLoader(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}



	@Override
	public void run(String... args) throws Exception {
//		PetType dog = new PetType();
//        dog.setName("Dog");
//        PetType savedDogPetType = petTypeService.save(dog);
//
//        PetType cat = new PetType();
//        cat.setName("Cat");
//        PetType savedCatPetType = petTypeService.save(cat);
//
//        Speciality radiology = new Speciality();
//        radiology.setDescription("Radiology");
//        Speciality savedRadiology = specialtyService.save(radiology);
//
//        Speciality surgery = new Speciality();
//        surgery.setDescription("Surgery");
//        Speciality savedSurgery = specialtyService.save(surgery);
//
//        Speciality dentistry = new Speciality();
//        dentistry.setDescription("dentistry");
//        Speciality savedDentistry = specialtyService.save(dentistry);
        
        
        
		OwnerPet owner1 = new OwnerPet();
		owner1.setId(1L);
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");

//		Pet mikesPet = new Pet();
//		mikesPet.setPetType(savedDogPetType);
//		mikesPet.setOwner(owner1);
//		mikesPet.setBirthDate(LocalDate.now());
//		mikesPet.setName("Rosco");
//		owner1.getPets().add(mikesPet);

		ownerService.save(owner1);

		OwnerPet owner2 = new OwnerPet();
		owner2.setId(2L);
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");

//		Pet fionasCat = new Pet();
//		fionasCat.setName("Just Cat");
//		fionasCat.setOwner(owner2);
//		fionasCat.setBirthDate(LocalDate.now());
//		fionasCat.setPetType(savedCatPetType);
//		owner2.getPets().add(fionasCat);

		ownerService.save(owner2);

//		Visit catVisit = new Visit();
//		catVisit.setPet(fionasCat);
//		catVisit.setDate(LocalDate.now());
//		catVisit.setDescription("Sneezy Kitty");

//		visitService.save(catVisit);

		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
//		vet1.getSpecialities().add(savedRadiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
//		vet2.getSpecialities().add(savedSurgery);

		vetService.save(vet2);

		System.out.println("Loaded Vets....");

	}

}