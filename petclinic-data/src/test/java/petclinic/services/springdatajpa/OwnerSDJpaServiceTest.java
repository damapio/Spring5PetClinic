package petclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*; // static import to avoid writing class name each time

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import petclinic.model.OwnerPet;
import petclinic.repositories.OwnerRepository;
import petclinic.service.springdatajpa.OwnerSDJpaService;


@ExtendWith(MockitoExtension.class)
public class OwnerSDJpaServiceTest {
	@InjectMocks
	private OwnerSDJpaService ownerService;

	@Mock private OwnerRepository ownerRepository;

    final Long ownerId = 1L;
    final String lastName = "Doe";
    
    OwnerPet returnOwner;

    @BeforeEach
    void setUp() {
    	// Mockito already initializes it
//        ownerService = new OwnerSDJpaService(ownerRepository);
    	
    	returnOwner = new OwnerPet();
    	returnOwner.setId(ownerId);
    	returnOwner.setLastName(lastName);
    }

    @Test
    void findAll() {
        Set<OwnerPet> returnOwnersSet = new HashSet<>();
        OwnerPet johnDoe = new OwnerPet();
        johnDoe.setId(ownerId);
        OwnerPet janeDoe = new OwnerPet();
        janeDoe.setId(2L);
        returnOwnersSet.add(johnDoe);
        returnOwnersSet.add(janeDoe);

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<OwnerPet> owners = ownerService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        OwnerPet owner = ownerService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        OwnerPet owner = ownerService.findById(1L);

        assertNull(owner);
    }
    
    @Test
    void findByLastName() {
    	when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
    	
    	returnOwner = ownerService.findByLastName(lastName);

        assertEquals(lastName, returnOwner.getLastName());

        //verify(ownerRepository, times(1)).findByLastName(any()); //verifies the method is called 1 time
        verify(ownerRepository).findByLastName(any()); //same, but shorter
    }


    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        
        OwnerPet newOwner = new OwnerPet();
        newOwner.setId(ownerId);
        OwnerPet savedOwner = ownerService.save(newOwner);

        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }


    @Test
    void delete() {
    	// verifies the method is called, but not whether it actually got deleted
    	ownerService.delete(returnOwner);
        
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
    	// verifies the method is called, but not whether it actually got deleted
    	ownerService.deleteById(ownerId);

        verify(ownerRepository).deleteById(anyLong());
    }


}
