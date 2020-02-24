package com.enigmacomp.service;

import java.util.List;

import com.enigmacomp.entities.Film;
import com.enigmacomp.entities.JamTayang;
import com.enigmacomp.entities.Studio;
import com.enigmacomp.entities.Tiket;
import com.enigmacomp.entities.Transaksi;

public interface TransaksiService {

	List<Film> listFilm();
	List<Transaksi> listTrans();
	List<Studio> listStudio();
	List<Tiket> listTiket();
	
	Transaksi save(Transaksi input) throws Exception;
	
	List<JamTayang> listTayang();
	

	
}
