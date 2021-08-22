package petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import petclinic.service.VetService;

@Controller
@RequestMapping("/vets")
public class VetController {
	
	private final VetService vetService;

	public VetController(VetService vetService) {
		super();
		this.vetService = vetService;
	}

	@RequestMapping({"", "/", "/index", "/index.html"})
	public String index(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
}
