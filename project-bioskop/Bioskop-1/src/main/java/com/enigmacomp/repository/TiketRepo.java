package com.enigmacomp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigmacomp.entities.Tiket;

public interface TiketRepo extends JpaRepository<Tiket, Integer> {

}
