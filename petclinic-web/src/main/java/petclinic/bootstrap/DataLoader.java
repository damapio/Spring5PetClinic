package petclinic.bootstrap;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import petclinic.model.OwnerPet;
import petclinic.model.Pet;
import petclinic.model.PetType;
import petclinic.model.Vet;
import petclinic.model.VetSpeciality;
import petclinic.model.Visit;
import petclinic.service.OwnerService;
import petclinic.service.PetTypeService;
import petclinic.service.VetService;
import petclinic.service.VetSpecialityService;
import petclinic.service.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final VetSpecialityService specialtyService;
	private final PetTypeService petTypeService;
	private final VisitService visitService;
	

	public DataLoader(OwnerService ownerService, VetService vetService,
			PetTypeService petTypeService, VetSpecialityService specialtyService,
			VisitService visitService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.specialtyService = specialtyService;
		this.petTypeService = petTypeService;
		this.visitService = visitService;
	}



	@Override
	public void run(String... args) throws Exception {
		if (petTypeService.findAll().size() == 0) {
			loadHashMapData();
		}
	}



	private void loadHashMapData() {
		PetType dog = new PetType();
        dog.setType("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setType("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        VetSpeciality radiology = new VetSpeciality();
        radiology.setDescription("Radiology");
        VetSpeciality savedRadiology = specialtyService.save(radiology);

        VetSpeciality surgery = new VetSpeciality();
        surgery.setDescription("Surgery");
        VetSpeciality savedSurgery = specialtyService.save(surgery);

        VetSpeciality dentistry = new VetSpeciality();
        dentistry.setDescription("dentistry");
        VetSpeciality savedDentistry = specialtyService.save(dentistry);
        
        
        
		OwnerPet owner1 = new OwnerPet();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setTelephone("123");

		Pet mikesPet = new Pet();
		mikesPet.setType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthday(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);

		ownerService.save(owner1);

		OwnerPet owner2 = new OwnerPet();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setTelephone("345");

		Pet fionasCat = new Pet();
		fionasCat.setName("Just Cat");
		fionasCat.setOwner(owner2);
		fionasCat.setBirthday(LocalDate.now());
		fionasCat.setType(savedCatPetType);
		owner2.getPets().add(fionasCat);
		
		ownerService.save(owner2);
		
//		fionasCat.setId(owner2.getPets().stream()
//				.filter(p -> p.getName().equals(fionasCat.getName()))
//				.map(p -> p.getId())
//				.collect(Collectors.toList()).get(0)); // este sistema es una mierda

		

		Visit catVisit = new Visit();
		catVisit.setPet(fionasCat);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Kitty");

		visitService.save(catVisit);

		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(savedRadiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(savedSurgery);

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}
