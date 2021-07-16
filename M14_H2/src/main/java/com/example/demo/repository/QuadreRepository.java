package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Quadre;

public interface QuadreRepository extends CrudRepository<Quadre, Integer> {


  Quadre findById(int id);
}