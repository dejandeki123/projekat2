package com.example.Project.service.implementation;

import java.sql.Date;

import com.example.Project.entity.Artikal;
import com.example.Project.entity.Korisnik;
import com.example.Project.entity.Korpa;
import com.example.Project.repository.KorpaRepository;
import com.example.Project.service.KorpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorpaServiceImplementation implements KorpaService{
      
    @Autowired
    private KorpaRepository korpaRepository;

     @Override
      public Korpa kreiraj_novu_korpu(Korpa korpa,Korisnik korisnik) {
          korpa.setKupac(korisnik.getIme()+ korisnik.getPrezime());
          korpa.setDatumPorudzbine("26.09.2019");
          korpa.setKorisnik(korisnik);
          Korpa korpa1=this.korpaRepository.save(korpa);
          return korpa1;
      }

     
}
