package com.enigmacamp.siswa.controller;


import com.enigmacamp.siswa.entities.PendaftaranSiswa;
import com.enigmacamp.siswa.entities.Status;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pendaftaransiswa")
public class PendaftaranController {
    List<PendaftaranSiswa> list = new ArrayList<PendaftaranSiswa>();
    List<PendaftaranSiswa> diterima = new ArrayList<PendaftaranSiswa>();
    List<PendaftaranSiswa> ditolak = new ArrayList<PendaftaranSiswa>();


    @PostMapping( value = "")
    public PendaftaranSiswa pendaftaranSiswa(@RequestBody PendaftaranSiswa siswa) {
        PendaftaranSiswa daftarSiswa = new PendaftaranSiswa();
        daftarSiswa.setId(siswa.getId());
        daftarSiswa.setName(siswa.getName());
        daftarSiswa.setAlamat(siswa.getAlamat());
        daftarSiswa.setNilai(siswa.getNilai());
        if (daftarSiswa.getNilai() >= 70) {
            this.diterima.add(daftarSiswa);
            daftarSiswa.setStatus(Status.BERHASIL);
        } else {
            this.ditolak.add(daftarSiswa);
            daftarSiswa.setStatus(Status.GAGAL);
        }this.list.add(daftarSiswa);
        return siswa;
    }

    @PutMapping(value = "/{id}")
    public PendaftaranSiswa update(@RequestBody PendaftaranSiswa siswa, @PathVariable Integer id) {
        for (PendaftaranSiswa baru : list)
            if(baru.getId() == id) {
                Integer index = list.indexOf(baru);
//                baru.setId(siswa.getId());
                baru.setName(siswa.getName());
                baru.setAlamat(siswa.getAlamat());
                baru.setNilai(siswa.getNilai());
                if (baru.getNilai() >= 70) {
                    this.diterima.add(baru);
                    baru.setStatus(Status.BERHASIL);
                } else {
                    this.ditolak.add(baru);
                    baru.setStatus(Status.GAGAL);
                }
                this.list.set(index, baru);
            }
        return siswa;
    }



    @GetMapping(value = "")
    public List<PendaftaranSiswa> getList() {

        return list;
    }

    @GetMapping(value = "/diterima")
    public List<PendaftaranSiswa> getDiterima() {

        return diterima;
    }

    @GetMapping(value = "/ditolak")
    public List<PendaftaranSiswa> getDitolak() {

        return ditolak;
    }

    @GetMapping(value = "/{id}")
    public PendaftaranSiswa finById(@PathVariable Integer id) {
        for (PendaftaranSiswa baru : list)
            if(baru.getId() == id);

        return list.get(id-1);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Integer id) {
        for (PendaftaranSiswa baru : list)
            if(baru.getId() == id) {

                list.remove(baru);
            }
    }
}
