package petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import petclinic.model.OwnerPet;
import petclinic.service.map.OwnerServiceMap;
import petclinic.service.map.PetTypeServiceMap;
import petclinic.service.map.PetServiceMap;

public class OwnerServiceMapTest {

	OwnerServiceMap ownerMapService;

    final Long ownerId = 1L;
    final String lastName = "Doe";

    @BeforeEach
    void setUp() {
    	// son clases tan básicas que no merece la pena usar un mock
        ownerMapService = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        OwnerPet johnDoe = new OwnerPet();
        johnDoe.setId(ownerId);
        johnDoe.setLastName(lastName);
        ownerMapService.save(johnDoe);
    }

    @Test
    void findAll() {
        Set<OwnerPet> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
    	OwnerPet owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveWithId() {
        Long id = 2L;
        OwnerPet johnDoe2 = new OwnerPet();
        johnDoe2.setId(id);
        OwnerPet savedOwner = ownerMapService.save(johnDoe2);

        assertEquals(id, savedOwner.getId());
        assertEquals(2, ownerMapService.findAll().size());
    }

    @Test
    void saveWithoutId() {
    	OwnerPet savedOwner = ownerMapService.save(new OwnerPet());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
    	OwnerPet smith = ownerMapService.findByLastName(lastName);

        assertNotNull(smith);
        assertEquals(ownerId, smith.getId());
    }

    @Test
    void findByLastNameNotFound() {
    	OwnerPet smith = ownerMapService.findByLastName("Mr. X");

        assertNull(smith);
    }
}
