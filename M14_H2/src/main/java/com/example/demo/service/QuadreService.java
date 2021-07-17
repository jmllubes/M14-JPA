package com.example.demo.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Botiga;
import com.example.demo.model.Quadre;
import com.example.demo.repository.BotigaRepository;
import com.example.demo.repository.QuadreRepository;

@Service
public class QuadreService {
	@Autowired
	private QuadreRepository quadreRepository;
	@Autowired
	private BotigaRepository botigaRepository;

	@Autowired
	private BotigaService botigaService;

	public List<Quadre> getAll() {
		List<Quadre> quadres = new ArrayList<>();
		quadreRepository.findAll().forEach(quadres::add);
		return quadres;
	}

	public void add(Quadre quadre) {
		quadreRepository.save(quadre);
	}

	public void delete(int id) {
		Botiga b = botigaRepository.findById(id);

		quadreRepository.deleteAll(botigaService.getAllQuadres(b));
	}
}