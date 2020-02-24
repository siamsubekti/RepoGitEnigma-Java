package com.enigmacomp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigmacomp.entities.Film;

public interface FilmRepo extends JpaRepository<Film, Integer> {

}
