package com.example.demo.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Botiga;
import com.example.demo.model.Quadre;
import com.example.demo.repository.BotigaRepository;

@Service
public class BotigaService {
	@Autowired
	private BotigaRepository botigaRepository;

	public List<Botiga> getAll() {
		List<Botiga> botigues = botigaRepository.findAll();

		return botigues;
	}

	public List<Quadre> getAllQuadres(Botiga b) {
		List<Quadre> quadres = b.getQuadres();
		return quadres;
	}

	public void add(Botiga botiga) {
		botigaRepository.save(botiga);
	}
}