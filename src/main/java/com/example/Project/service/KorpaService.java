package com.example.Project.service;

import com.example.Project.entity.Artikal;
import com.example.Project.entity.Korisnik;
import com.example.Project.entity.Korpa;

public interface KorpaService {
    Korpa kreiraj_novu_korpu(Korpa korpa,Korisnik korisnik); 
    
}
