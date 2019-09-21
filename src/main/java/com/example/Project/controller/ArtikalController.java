package com.example.Project.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.Project.entity.Artikal;
import com.example.Project.service.ArtikalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ArtikalController {

    @Autowired
    private ArtikalService artikalService;

    @GetMapping("/artikli_neprijavljeni_korisnici") 
    public String ArtikleIspisi(Model model) {
        model.addAttribute("artikli",this.artikalService.lista_svih_artikala());
        return "artikli_neprijavljeni.html";
    }



    @GetMapping("/domacaKnjizevnost")
    public String ispisArtikalaDomacaKnjizevnost(Model model) {
        List<Artikal> artikliDomaceKnjizevnosti=new ArrayList<>();
       
        artikliDomaceKnjizevnosti=this.artikalService.ispisArtikalaPoKategoriji("domacaKnjizevnost");
        model.addAttribute("artikli", artikliDomaceKnjizevnosti);

        return "artikli_neprijavljeni.html";

    }

    @GetMapping("/stranaKnjizevnost")
    public String ispisArtikalaStranaKnjizevnost(Model model) {
        List<Artikal> artikliStraneKnjizevnosti=new ArrayList<>();
       
        artikliStraneKnjizevnosti=this.artikalService.ispisArtikalaPoKategoriji("stranaKnjizevnost");
        model.addAttribute("artikli", artikliStraneKnjizevnosti);

        return "artikli_neprijavljeni.html";

    }

    @GetMapping("/sviArtikli") 
    public String vrati_se_na_sve_artikle(Model model) {

        model.addAttribute("artikli",this.artikalService.lista_svih_artikala());

        return "artikli_neprijavljeni.html";
    }

    @GetMapping("/sortirajPoNazivu")
    public String sortiranje_po_imenu(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoNazivu());

        return "artikli_neprijavljeni.html";
    }

    @GetMapping("/sortirajPoId")
    public String sortiranje_po_id(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoId());

        return "artikli_neprijavljeni.html";
    }

    @GetMapping("/sortirajPoCeni")
    public String sortiranje_po_ceni(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoCeni());
    
        return "artikli_neprijavljeni.html";
    }


    @GetMapping("/artikliNaPopustu")
    public String ispisi_artikle_na_popustu(Model model) {
        List<Artikal> artikli_na_popustu=new ArrayList<>();
       
        artikli_na_popustu=this.artikalService.ispisArtikalaNaPopustu();
        model.addAttribute("artikli", artikli_na_popustu);

        return "artikli_neprijavljeni.html";

    }

    @PostMapping("/pretraga")
    public String pretrazeni_artikli(Model model, @ModelAttribute("artikal") Artikal artikal1) {
         List<Artikal> artikli = this.artikalService.pretraga_artikala(artikal1);
         model.addAttribute("artikli", artikli);
          return "artikli_neprijavljeni.html"; 
        
        }


@GetMapping("/izbrisiArtikal/{id}")
public String izbrisi_artikal(@PathVariable("id") Long id) {
    this.artikalService.izbrisi_artikal(id);

    
    return "redirect:/artikli";
}

List<Artikal> lista_omiljenih=new ArrayList<>();

@GetMapping("/dodaj_u_omiljene/{id}")
public String spisak_omiljenih(@PathVariable("id") Long id,Model model) {

    Artikal omiljeni=this.artikalService.pronadji_artikal_po_id(id);
    lista_omiljenih.add(omiljeni);

    model.addAttribute("artikli", lista_omiljenih);
    
    return "omiljeniArtikli.html";
}

@GetMapping("/omiljeniArtikli") 
public String pogledajOmiljene(Model model) {

    List<Artikal> lista=lista_omiljenih;
   
    model.addAttribute("artikli",lista);
    return "omiljeniArtikli.html";
}




    

}


    

    
    

    

