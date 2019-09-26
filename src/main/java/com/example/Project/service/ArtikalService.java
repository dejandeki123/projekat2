package com.example.Project.service;

import java.util.List;

import com.example.Project.entity.Artikal;
import com.example.Project.entity.Korpa;

public interface ArtikalService {
    List<Artikal> lista_svih_artikala();

    List<Artikal> ispisArtikalaPoKategoriji(String kategorija);

    List<Artikal> sortiranjePoNazivu();

    List<Artikal> sortiranjePoId();

    List<Artikal> sortiranjePoCeni();

    List<Artikal> ispisArtikalaNaPopustu();

    void izbrisi_artikal(Long id);

    Artikal pronadji_artikal_po_id(Long id);

    Artikal kreiraj_artikal(Artikal artikal);
   // List<Artikal> pretraziPoKategorija(String kategorija);

    List<Artikal> pretraga_artikala(Artikal artikal);

    void ubacivanje_artikla_u_korpu(Korpa korpa,Artikal artikal);

    List<Artikal> dobavi_one_u_korpi(Korpa korpa);

}
