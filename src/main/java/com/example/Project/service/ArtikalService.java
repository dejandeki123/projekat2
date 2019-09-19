package com.example.Project.service;

import java.util.List;

import com.example.Project.entity.Artikal;

public interface ArtikalService {
    List<Artikal> lista_svih_artikala();

    List<Artikal> ispisArtikalaPoKategoriji(String kategorija);

    List<Artikal> sortiranjePoNazivu();

    List<Artikal> sortiranjePoId();

    List<Artikal> sortiranjePoCeni();

    List<Artikal> ispisArtikalaNaPopustu();

    void izbrisi_artikal(Long id);

    Artikal pronadji_artikal_po_id(Long id);

  
   // List<Artikal> pretraziPoKategorija(String kategorija);

  //  List<Artikal> pretraga_artikala(String unos);

}