package petclinic.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import petclinic.model.OwnerPet;
import petclinic.service.OwnerService;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {
	
	@InjectMocks
	private OwnerController ownerController;
	
	@Mock private OwnerService ownerService;
	
	private Set<OwnerPet> mockOwnersSet;
	
	private MockMvc mockMVC;
	
	@BeforeEach
	void setUp( ) {
		mockOwnersSet = new HashSet<>();
		
		OwnerPet owner = new OwnerPet();
		owner.setId(1L);
//    	returnOwner.setLastName(lastName);
		mockOwnersSet.add(owner);
		
		OwnerPet owner2 = new OwnerPet();
		owner2.setId(2L);
		mockOwnersSet.add(owner2);
		
		mockMVC = MockMvcBuilders.standaloneSetup(ownerController).build();
	}
	
	@Test
	void getOwnersPage() throws Exception {
		when(ownerService.findAll()).thenReturn(mockOwnersSet);
		
		mockMVC.perform(get("/owners"))
	        .andExpect(status().isOk())
	        .andExpect(view().name("owners/index"))							//mockito
	        .andExpect(model().attribute("owners", Matchers.hasSize(2)));	//hamcrest
	}
	
	@Test
	void getIndexPage() throws Exception {
		when(ownerService.findAll()).thenReturn(mockOwnersSet);
		
		mockMVC.perform(get("/owners/index"))
	        .andExpect(status().isOk())
	        .andExpect(view().name("owners/index"))							
	        .andExpect(model().attribute("owners", Matchers.hasSize(2)));	
	}
	
	@Test
	void findOwners()  throws Exception {
		mockMVC.perform(get("/owners/find"))
        .andExpect(status().isOk())
        .andExpect(view().name("404")); 
	}

}
