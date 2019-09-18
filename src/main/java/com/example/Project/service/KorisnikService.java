package com.example.Project.service;

import java.util.List;

import com.example.Project.entity.Korisnik;

public interface KorisnikService {
     Boolean proveriPrijavu(String korisnicko,String lozinka);

     void izbrisi(Long id);

     Korisnik pronadji_korisnika_za_registraciju(String korisnicko);

     List<Korisnik> pronadji_sve_korisnike();

     Korisnik kreiraj_korisnika(Korisnik korisnik)throws Exception;

     Korisnik pronadji_jednog_korisnika_po_id(Long id);
}