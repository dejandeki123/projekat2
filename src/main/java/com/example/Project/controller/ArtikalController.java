package com.example.Project.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.Project.entity.Artikal;
import com.example.Project.entity.Pretraga;
import com.example.Project.service.ArtikalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ArtikalController {

    @Autowired
    private ArtikalService artikalService;

    @GetMapping("/artikli") 
    public String ArtikleIspisi(Model model) {
        model.addAttribute("artikli",this.artikalService.lista_svih_artikala());
        return "artikli.html";
    }

    @GetMapping("/domacaKnjizevnost")
    public String ispisArtikalaDomacaKnjizevnost(Model model) {
        List<Artikal> artikliDomaceKnjizevnosti=new ArrayList<>();
       
        artikliDomaceKnjizevnosti=this.artikalService.ispisArtikalaPoKategoriji("domacaKnjizevnost");
        model.addAttribute("artikli", artikliDomaceKnjizevnosti);
        model.addAttribute("nova_pretraga", new Pretraga());

        return "artikli.html";

    }

    @GetMapping("/stranaKnjizevnost")
    public String ispisArtikalaStranaKnjizevnost(Model model) {
        List<Artikal> artikliStraneKnjizevnosti=new ArrayList<>();
       
        artikliStraneKnjizevnosti=this.artikalService.ispisArtikalaPoKategoriji("stranaKnjizevnost");
        model.addAttribute("artikli", artikliStraneKnjizevnosti);
        model.addAttribute("nova_pretraga", new Pretraga());

        return "artikli.html";

    }

    @GetMapping("/sviArtikli") 
    public String vrati_se_na_sve_artikle(Model model) {

        model.addAttribute("artikli",this.artikalService.lista_svih_artikala());
        model.addAttribute("nova_pretraga", new Pretraga());

        return "artikli.html";
    }

    @GetMapping("/sortirajPoNazivu")
    public String sortiranje_po_imenu(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoNazivu());
        model.addAttribute("nova_pretraga", new Pretraga());

        return "artikli.html";
    }

    @GetMapping("/sortirajPoId")
    public String sortiranje_po_id(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoId());
        model.addAttribute("nova_pretraga", new Pretraga());

        return "artikli.html";
    }

    @GetMapping("/sortirajPoCeni")
    public String sortiranje_po_ceni(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoCeni());
    
        return "artikli.html";
    }


    @GetMapping("/artikliNaPopustu")
    public String ispisi_artikle_na_popustu(Model model) {
        List<Artikal> artikli_na_popustu=new ArrayList<>();
       
        artikli_na_popustu=this.artikalService.ispisArtikalaNaPopustu();
        model.addAttribute("artikli", artikli_na_popustu);
        model.addAttribute("nova_pretraga", new Pretraga());

        return "artikli.html";

    }
/*
    @PostMapping("/pretraga_artikala")
    public String pretrazeni_artikli(@ModelAttribute Pretraga prettraga, Model model) {
         List<Artikal> oni_koji_odgovaraju_pretrazi=new ArrayList<>();
    
         String pretraga=prettraga.getPretrazeno();
         System.out.println(pretraga);
         oni_koji_odgovaraju_pretrazi=this.artikalService.pretraga_artikala(pretraga);

         model.addAttribute("artikli", oni_koji_odgovaraju_pretrazi);
         model.addAttribute("nova_pretraga", new Pretraga());
         
          return "artikli.html"; 
        
        
        
        }
*/

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


    

    
    

    

