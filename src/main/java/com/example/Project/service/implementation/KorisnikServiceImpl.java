package com.example.Project.service.implementation;

import java.util.List;

import com.example.Project.entity.Korisnik;
import com.example.Project.repository.KorisnikRepository;
import com.example.Project.service.KorisnikService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;
   
    @Override
    public Boolean proveriPrijavu(String korisnicko,String lozinka) {

        if(this.korisnikRepository.findOneByKorisnickoIme(korisnicko) != null && this.korisnikRepository.findOneByKorisnickoIme(korisnicko).getLozinka().equals(lozinka)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Korisnik pronadji_korisnika_za_registraciju(String korisnicko) {
        Korisnik korisnik=korisnikRepository.findOneByKorisnickoIme(korisnicko);
        return korisnik;
    }
  

    @Override 
    public void izbrisi(Long id) {
        this.korisnikRepository.deleteById(id);

    }

    @Override
    public Korisnik kreiraj_korisnika(Korisnik korisnik) throws Exception{
         Korisnik novi_korisnik=korisnikRepository.save(korisnik);
         return novi_korisnik;
    }

    @Override
    public  List<Korisnik> pronadji_sve_korisnike() {
        List<Korisnik> korisnici= this.korisnikRepository.findAll();
        return korisnici;
    }

    @Override
    public Korisnik pronadji_jednog_korisnika_po_id(Long id) {
    Korisnik korisnik = this.korisnikRepository.getOne(id);
        return korisnik;
    }

    @Override
    public  Korisnik pronadji_po_korisnickom_i_lozinki(String korisnicko,String lozinka){
        Korisnik prijavljeni=this.korisnikRepository.findOneByKorisnickoImeAndLozinka(korisnicko, lozinka);
        return prijavljeni;
    }
    
    @Override
     public void izbrisi_korisnika(Long id){
         this.korisnikRepository.deleteById(id);
     }

    
}