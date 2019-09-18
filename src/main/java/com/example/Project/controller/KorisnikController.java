package com.example.Project.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.Project.entity.Korisnik;
import com.example.Project.service.KorisnikService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KorisnikController
{
   
    @Autowired
    private KorisnikService korisnikService;
    
    @GetMapping("/")
    public String dobrodosliNaPocetnu() {
        return "pocetna.html";
    }

    @GetMapping("/prijava")
    public String prijava(Model model) {
        Korisnik zaPrijavuKorisnik=new Korisnik();
        model.addAttribute("korisnik", zaPrijavuKorisnik);
        
        return "prijava.html";
    }


    @PostMapping("/prijavaProvera")
    public String proveriPrijavu(@Valid @ModelAttribute Korisnik korisnik, BindingResult errors, Model model) {
         
      if(!(this.korisnikService.proveriPrijavu(korisnik.getKorisnickoIme(),korisnik.getLozinka()))) {
           return "neuspelaPrijava.html";
      }

      else {

        Korisnik prijavljeniKorisnik=new Korisnik();
        model.addAttribute("korisnik", prijavljeniKorisnik);
           return "uspesnaPrijava.html";
      }
    }

      


    @GetMapping("/registracija")
    public String registrujSe(Model model) {
        model.addAttribute("korisnik", new Korisnik());
        return "registracija.html"; 
     
    }




     @PostMapping("/registracijaProvera")
     public String proveriRegistraciju(@Valid @ModelAttribute Korisnik korisnik, BindingResult errors, Model model)throws Exception{
        if(this.korisnikService.pronadji_korisnika_za_registraciju(korisnik.getKorisnickoIme()) == null) {
              
             this.korisnikService.kreiraj_korisnika(korisnik);  
                return "prijava.html";
            }

            else{
                return "neuspesnaRegistracija.html";
            }
          }
   
     @GetMapping("/korisnici")
     public String prikaziKorisnike(Model model) {
      List<Korisnik> lista = this.korisnikService.pronadji_sve_korisnike();
      model.addAttribute("korisnici", lista);
      return "korisnici.html";
     }

     @GetMapping("/korisnici/{id}")
     public String prikaziJednogKorisnika(@PathVariable(name = "id") Long id, Model model) {
         Korisnik korisnik = this.korisnikService.pronadji_jednog_korisnika_po_id(id);
         model.addAttribute("korisnik", korisnik);
         return "korisnik.html";
     }   
   
     

} 

