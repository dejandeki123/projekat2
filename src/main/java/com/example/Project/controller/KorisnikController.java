package com.example.Project.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.Project.entity.Korisnik;
import com.example.Project.entity.Korpa;
import com.example.Project.service.KorisnikService;
import com.example.Project.service.KorpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KorisnikController
{
   
    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private KorpaService korpaService;
    
    
    @GetMapping("/")
    public String dobrodosliNaPocetnu() {
      return "pocetna_neprijavljeni.html";

    
    }

    @GetMapping("/kupac_pocetna/{id}")
    public String dobrodosliNaPocetnuKupac(@PathVariable(name="id")Long id,Model model) {
        Korisnik korisnik_koji_je_prijavljen=this.korisnikService.pronadji_jednog_korisnika_po_id(id);

        Korpa nova_korpa=new Korpa();
        nova_korpa=this.korpaService.kreiraj_novu_korpu(nova_korpa,korisnik_koji_je_prijavljen);
        model.addAttribute("prijavljeni_k", id);
       return "pocetna_kupac.html";

    }

    @GetMapping("/admin_pocetna/{id}")
    public String dobrodosliNaPocetnuAdmin(@PathVariable(name="id")Long id,Model model) {
        model.addAttribute("prijavljeni_k", id);

        return "pocetna_admin.html";

    }



    @GetMapping("/prijava")
    public String prijava(Model model) {
        return "prijava.html";
    }


    @PostMapping("/prijavaProvera")
    public String proveriPrijavu(@RequestParam String korisnickoIme,@RequestParam String lozinka,Model model) {
            Korisnik prijavljeni_k=this.korisnikService.pronadji_po_korisnickom_i_lozinki(korisnickoIme,lozinka);
            model.addAttribute("prijavljeni_k", prijavljeni_k);
            return "proveraPrijave.html";
         

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
   
     @GetMapping("/trenutni_korisnik/{id}")
     public String prikazTrenutnogKorisnika(@PathVariable(name = "id") Long id, Model model) {
         Korisnik trenutni = this.korisnikService.pronadji_jednog_korisnika_po_id(id);
         model.addAttribute("korisnik", trenutni);
         return "korisnik.html";
     }   
   
     @GetMapping("/izbrisi_korisnika/{id}")
    public String izbrisi_korisnika(@PathVariable("id") Long id) {
    this.korisnikService.izbrisi_korisnika(id);

    return "redirect:/korisnici";
}

} 

