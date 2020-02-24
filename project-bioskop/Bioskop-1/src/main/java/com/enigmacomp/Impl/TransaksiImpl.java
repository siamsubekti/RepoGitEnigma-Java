package com.enigmacomp.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigmacomp.entities.Film;
import com.enigmacomp.entities.JamTayang;
import com.enigmacomp.entities.Studio;
import com.enigmacomp.entities.Tiket;
import com.enigmacomp.entities.Transaksi;
import com.enigmacomp.repository.FilmRepo;
import com.enigmacomp.repository.JamTayangRepo;
import com.enigmacomp.repository.StudioRepo;
import com.enigmacomp.repository.TiketRepo;
import com.enigmacomp.repository.TimesRepo;
import com.enigmacomp.repository.TransaksiRepo;
import com.enigmacomp.service.TransaksiService;

@Service
public class TransaksiImpl implements TransaksiService{
	@Autowired
	FilmRepo filmRepo;
	
	@Autowired
	StudioRepo studioRepo;
	
	@Autowired
	TiketRepo tiketRepo;
	
	@Autowired
	JamTayangRepo jamRepo;
	
	@Autowired
	TimesRepo timeRepo;
	
	@Autowired
	TransaksiRepo transRepo;
	
	@Override
	public List<Film> listFilm() {
		// TODO Auto-generated method stub
		return filmRepo.findAll();
	}
	

	@Override
	public List<Studio> listStudio() {
		// TODO Auto-generated method stub
		return studioRepo.findAll();
	}


	@Override
	public List<Transaksi> listTrans() {
		// TODO Auto-generated method stub
		return transRepo.findAll();
	}


	//INI KEPUNYAAN TIKET
	@Override
	public List<Tiket> listTiket() {
		// TODO Auto-generated method stub
		return tiketRepo.findAll();
	}


	@Override
	public List<JamTayang> listTayang() {
		// TODO Auto-generated method stub
		return jamRepo.findAll();
	}


	@Override
	public Transaksi save(Transaksi input) throws Exception {
		// TODO Auto-generated method stub
		Transaksi trans = new Transaksi();
		JamTayang jam = input.getTrxJamTayang();
				
		trans.setId(input.getId());
		trans.setJumlah(input.getJumlah());
		trans.setTanggal(input.getTanggal());
		trans.setTrxJamTayang(input.getTrxJamTayang());
		trans.setTrxTiket(input.getTrxTiket());
		
		Integer totalHarga = input.getJumlah() * input.getTrxTiket().getHarga();
		trans.setTotal(totalHarga);
		
		
		if(input.getJumlah() <= jam.getKuota()) {
			Integer kuota = jam.getKuota() - input.getJumlah();
			jam.setKuota(kuota);
			transRepo.save(trans);
			jamRepo.save(jam);
			return trans;
		}else {
			throw new Exception("Kuota Tidak Cukup");
		}
		
		
				
		
	}

	
	
	
	

	
	
	
	
	
	
	

}
