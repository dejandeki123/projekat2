package com.example.Project.repository;

import com.example.Project.entity.Korisnik;

import org.springframework.data.jpa.repository.JpaRepository;



public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {
    Korisnik findOneByKorisnickoIme(String korisnickoIme);
    Korisnik findOneByKorisnickoImeAndLozinka(String korisnickoIme,String lozinka);
    
}