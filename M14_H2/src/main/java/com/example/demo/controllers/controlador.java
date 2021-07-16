package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.repository.BotigaRepository;
import com.example.demo.repository.QuadreRepository;

@Controller
public class controlador {

	@Autowired
	BotigaRepository botigarepo;
	@Autowired
	QuadreRepository quadrerepo;
	
	@RequestMapping
	public String getEmpleats(Model model) {
		
		List<Empleat> llistaEmpleats = empleatService.getEmpleats();
		
		model.addAttribute("empleats", llistaEmpleats);
		
		return "index";
	}

	@GetMapping("/buscar/{id}")
	public String buscarEmpleatId(Model model, Integer id) {
		
		model.addAttribute("empleats", empleatService.getEmpleat(id));
		
		return "index";
	}
	
	@GetMapping("/buscar/{ofici}")
	public String buscarEmpleatOfici(Model model, String ofici) {
		
		model.addAttribute("empleats", empleatService.getEmpleatOfici(ofici));
		
		return "index";
	}
	
	@RequestMapping({"/editar/{id}"})
	public String editarEmpleat(Model model, @PathVariable("id") Integer id) {
		
		model.addAttribute("empleat", empleatService.getEmpleat(id));		
		return "editar";

	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarEmpleat(Model model, @PathVariable("id") Integer id) {
		System.out.println("RequestMapping: 'eliminarEmpleatPorId' " + id);
		
		empleatService.borrar(id);
		
		return "redirect:/";
	}
	
	@RequestMapping("/crear")
	public String crearEmpleat(Model model) {
		
		System.out.println("RequestMapping: 'crearEmpleat'");
		model.addAttribute("empleat", new Empleat());
		
		return "crear";
	}
	
	
	
	@RequestMapping(path = "/insertarEmpleat", method = RequestMethod.POST)
	public String insertarEmpleat(String nom, String ofici) {
		

		empleatService.inserta(nom,ofici);
		
		return "redirect:/";
	}
	
	@RequestMapping(path = "/modificaEmpleat", method = RequestMethod.POST)
	public String modificarEmpleat(String nom, String ofici , int id) {
		
		Empleat empleat = new Empleat(id,nom,Ofici.valueOf(ofici));

		empleatService.modificar(empleat);
		
		return "redirect:/";
	}
	
}
