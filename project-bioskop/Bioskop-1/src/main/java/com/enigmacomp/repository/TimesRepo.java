package com.enigmacomp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigmacomp.entities.Times;

public interface TimesRepo extends JpaRepository<Times, Integer>{

}
