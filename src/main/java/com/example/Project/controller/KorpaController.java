package com.example.Project.controller;

import com.example.Project.entity.Artikal;
import com.example.Project.entity.Korisnik;
import com.example.Project.entity.Korpa;
import com.example.Project.service.ArtikalService;
import com.example.Project.service.KorisnikService;
import com.example.Project.service.KorpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class KorpaController {

    @Autowired
    public KorisnikService korisnikService;
        
    @Autowired
    public KorpaService korpaService;

    @Autowired
    public ArtikalService artikalService;

    

   @GetMapping("kreirajKorpu")
   public String kreiraj_korpu(Model model) {
           Korpa korpa=new Korpa();
           model.addAttribute("korpa",korpa);
           return "korpa.html";
       
   } 

   @GetMapping("dodaj_u_korpu/{idArtikla}/{idKorisnika}")
   public String dodavanje_u_korpu(@PathVariable(name="idArtikla")Long idArtikla,@PathVariable(name="idKorisnika")Long idKorisnika,Model model) {
        Korisnik onaj_sto_je_prijavljen=this.korisnikService.pronadji_jednog_korisnika_po_id(idKorisnika);
        Artikal ubacujemo_u_korpu=this.artikalService.pronadji_artikal_po_id(idArtikla);

        Korpa korpa=onaj_sto_je_prijavljen.getPotrosackaKorpa();
        this.artikalService.ubacivanje_artikla_u_korpu(korpa,ubacujemo_u_korpu);
        model.addAttribute("artikli",this.artikalService.dobavi_one_u_korpi(korpa));
        return "dodati_artikli_kupac.html";

   }

   

   @GetMapping("/vidiKorpu/{idKorisnika}")
public String vidi_proizvode_u_korpi(@PathVariable(name="idKorisnika")Long idKorisnika,Model model){
        Korisnik onaj_sto_je_prijavljen=this.korisnikService.pronadji_jednog_korisnika_po_id(idKorisnika);
        Korpa korpa=onaj_sto_je_prijavljen.getPotrosackaKorpa();
        model.addAttribute("artikli",this.artikalService.dobavi_one_u_korpi(korpa));
        return "dodati_artikli_kupac.html";
}



  

 

}