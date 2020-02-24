package com.enigmacomp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enigmacomp.entities.Film;
import com.enigmacomp.entities.JamTayang;
import com.enigmacomp.entities.Studio;
import com.enigmacomp.entities.Tiket;
import com.enigmacomp.entities.Transaksi;
import com.enigmacomp.service.TransaksiService;

@RestController
@RequestMapping("/bioskop")
public class TransaksiController {
	
	@Autowired
	TransaksiService transService;

	@GetMapping("/film")
	public List<Film> listAll(){
		return transService.listFilm();
	}
	
	@GetMapping("/studio")
	public List<Studio> listStudio(){
		return transService.listStudio();
	}
	
	@GetMapping("/tiket")
	public List<Tiket> listTiket() {
		return transService.listTiket();
	}
	
	@GetMapping("/")
	public List<JamTayang> listJam(){
		return transService.listTayang();
	}
	
	@PostMapping("/transaksi")
	public Transaksi trans(@RequestBody Transaksi input) throws Exception {
		return transService.save(input);
	}
	
	@GetMapping("/transaksi")
		public List<Transaksi> list(){
			return transService.listTrans();
		
	}
	
	
	
	
	
	
}
