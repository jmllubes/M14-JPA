package com.example.demo.controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Botiga;
import com.example.demo.model.Quadre;
import com.example.demo.repository.BotigaRepository;
import com.example.demo.repository.QuadreRepository;
import com.example.demo.service.BotigaService;
import com.example.demo.service.QuadreService;

@RestController
public class controlador {

	@Autowired
	private BotigaRepository botigaRepository;
	@Autowired
	private BotigaService botigaService;

	@Autowired
	private QuadreService quadreService;

	@GetMapping("/shops")
	public List<Botiga> getAllBotiga() {
		return botigaService.getAll();
	}

	@PostMapping("/shops")
	public void addBotiga(@RequestBody Botiga botiga) {
		botigaService.add(botiga);
	}

	@GetMapping("/shops/{id}/pictures")
	public List<Quadre> getAllQuadre() {
		return quadreService.getAll();
	}

	@PostMapping("/shops/{id}/pictures")
	public void addQuadre(@RequestParam String nom, String autor, @PathVariable int id) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Botiga b = botigaRepository.findById(id);
		Quadre q = new Quadre(timestamp, nom, 0, autor, b);
		quadreService.add(q);
	}

	@DeleteMapping("/shops/{id}/pictures")
	public void deleteQuadre(@PathVariable int id) {
		quadreService.delete(id);
		;
	}

}
