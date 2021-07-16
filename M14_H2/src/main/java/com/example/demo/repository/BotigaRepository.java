package com.example.demo.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Botiga;

public interface BotigaRepository extends CrudRepository<Botiga, Integer> {

  Botiga findById(int id);
}