package com.enigmacomp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigmacomp.entities.Transaksi;

public interface TransaksiRepo extends JpaRepository<Transaksi, Integer>{

}
