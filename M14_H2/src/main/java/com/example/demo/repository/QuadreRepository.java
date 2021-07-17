package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Quadre;

public interface QuadreRepository extends JpaRepository<Quadre, Integer> {


  Quadre findById(int id);
}