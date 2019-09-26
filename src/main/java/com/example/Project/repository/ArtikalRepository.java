package com.example.Project.repository;

import java.util.List;

import com.example.Project.entity.Artikal;
import com.example.Project.entity.Korpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtikalRepository extends JpaRepository<Artikal, Long> {

    List<Artikal> findAllByKategorija(String kategorija);
   
    List<Artikal> findAllByOrderByNaziv();

    List<Artikal> findAllByOrderById();

    List<Artikal> findAllByOrderByCena();
   
    List<Artikal> findAll();

    Artikal findOneById(Long id);
   
    List<Artikal> findAllByNaziv(String naziv);

    List<Artikal> findAllByKorpa(Korpa korpa);

//    void deleteByID(Long id);

    
}