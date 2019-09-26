package com.example.Project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.example.Project.entity.Artikal;
import com.example.Project.entity.Korpa;
import com.example.Project.service.ArtikalService;
import com.example.Project.service.KorpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ArtikalController {

    @Autowired
    private ArtikalService artikalService;



    @GetMapping("/artikli") 
    public String pregled_svih_artikala(Model model) {
        model.addAttribute("artikli",this.artikalService.lista_svih_artikala());
        return "artikli_neprijavljeni.html";
    }

    @GetMapping("/artikli_kupac/{id}") 
    public String pregled_svih_artikalaKupac(@PathVariable(name="id")Long id,Model model) {
        model.addAttribute("artikli",this.artikalService.lista_svih_artikala());
        model.addAttribute("prijavljeni_k",id);


        return "artikli_kupac.html";
    }



    
    @GetMapping("/admin_artikli/{id}") 
    public String pregled_svih_artikalaAdmin(@PathVariable(name="id")Long id,Model model) {
        model.addAttribute("artikli",this.artikalService.lista_svih_artikala());
        model.addAttribute("prijavljeni_k",id);


        return "admin_artikli.html";
    }

    @GetMapping("/dodaj_artikal_admin")
    public String dodajArtikal(Model model) {
        Artikal artikal=new Artikal();
        model.addAttribute("novi_artikal", artikal);
        return "dodaj_artikal.html";

    }

    @PostMapping("/sacuvaj_artikal")
    public String sacuvaj_artikal(@Valid @ModelAttribute Artikal novi_artikal, BindingResult errors, Model model){
           
        this.artikalService.kreiraj_artikal(novi_artikal);
      
        return "redirect:/admin_artikli";
    }





    @GetMapping("/domacaKnjizevnost")
    public String ispisArtikalaDomacaKnjizevnost(Model model) {
        List<Artikal> artikliDomaceKnjizevnosti=new ArrayList<>();
       
        artikliDomaceKnjizevnosti=this.artikalService.ispisArtikalaPoKategoriji("domacaKnjizevnost");
        model.addAttribute("artikli", artikliDomaceKnjizevnosti);

        return "artikli_neprijavljeni.html";

    }

    @GetMapping("/domacaKnjizevnost_kupac")
    public String ispisArtikalaDomacaKnjizevnostKupac(Model model) {
        List<Artikal> artikliDomaceKnjizevnosti=new ArrayList<>();
       
        artikliDomaceKnjizevnosti=this.artikalService.ispisArtikalaPoKategoriji("domacaKnjizevnost");
        model.addAttribute("artikli", artikliDomaceKnjizevnosti);

        return "artikli_kupac.html";

    }

    @GetMapping("/domacaKnjizevnost_admin")
    public String ispisArtikalaDomacaKnjizevnostAdmin(Model model) {
        List<Artikal> artikliDomaceKnjizevnosti=new ArrayList<>();
       
        artikliDomaceKnjizevnosti=this.artikalService.ispisArtikalaPoKategoriji("domacaKnjizevnost");
        model.addAttribute("artikli", artikliDomaceKnjizevnosti);

        return "admin_artikli.html";

    }

    @GetMapping("/stranaKnjizevnost")
    public String ispisArtikalaStranaKnjizevnost(Model model) {
        List<Artikal> artikliStraneKnjizevnosti=new ArrayList<>();
       
        artikliStraneKnjizevnosti=this.artikalService.ispisArtikalaPoKategoriji("stranaKnjizevnost");
        model.addAttribute("artikli", artikliStraneKnjizevnosti);

        return "artikli_neprijavljeni.html";

    }

    @GetMapping("/stranaKnjizevnost_kupac")
    public String ispisArtikalaStranaKnjizevnostKupac(Model model) {
        List<Artikal> artikliStraneKnjizevnosti=new ArrayList<>();
       
        artikliStraneKnjizevnosti=this.artikalService.ispisArtikalaPoKategoriji("stranaKnjizevnost");
        model.addAttribute("artikli", artikliStraneKnjizevnosti);

        return "artikli_kupac.html";

    }

    @GetMapping("/stranaKnjizevnost_admin")
    public String ispisArtikalaStranaKnjizevnostAdmin(Model model) {
        List<Artikal> artikliStraneKnjizevnosti=new ArrayList<>();
       
        artikliStraneKnjizevnosti=this.artikalService.ispisArtikalaPoKategoriji("stranaKnjizevnost");
        model.addAttribute("artikli", artikliStraneKnjizevnosti);

        return "admin_artikli.html";

    }

    @GetMapping("/sviArtikli") 
    public String vrati_se_na_sve_artikle(Model model) {

        model.addAttribute("artikli",this.artikalService.lista_svih_artikala());

        return "artikli_neprijavljeni.html";
    }

    @GetMapping("/sviArtikli_kupac") 
    public String vrati_se_na_sve_artikleKupac(Model model) {

        model.addAttribute("artikli",this.artikalService.lista_svih_artikala());

        return "artikli_kupac.html";
    }

    @GetMapping("/sviArtikli_admin") 
    public String vrati_se_na_sve_artikleAdmin(Model model) {

        model.addAttribute("artikli",this.artikalService.lista_svih_artikala());

        return "admin_artikli.html";
    }


    @GetMapping("/sortirajPoNazivu")
    public String sortiranje_po_imenu(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoNazivu());

        return "artikli_neprijavljeni.html";
    }

    @GetMapping("/sortirajPoNazivu_kupac")
    public String sortiranje_po_imenuKupac(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoNazivu());

        return "artikli_kupac.html";
    }

    @GetMapping("/sortirajPoNazivu_admin")
    public String sortiranje_po_imenuAdmin(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoNazivu());

        return "admin_artikli.html";
    }

    @GetMapping("/sortirajPoId")
    public String sortiranje_po_id(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoId());

        return "artikli_neprijavljeni.html";
    }

    @GetMapping("/sortirajPoId_kupac")
    public String sortiranje_po_idKupac(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoId());

        return "artikli_kupac.html";
    }

    @GetMapping("/sortirajPoId_admin")
    public String sortiranje_po_idAdmin(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoId());

        return "admin_artikli.html";
    }


    @GetMapping("/sortirajPoCeni")
    public String sortiranje_po_ceni(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoCeni());
    
        return "artikli_neprijavljeni.html";
    }

    @GetMapping("/sortirajPoCeni_kupac")
    public String sortiranje_po_ceniKupac(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoCeni());
    
        return "artikli_kupac.html";
    }

    @GetMapping("/sortirajPoCeni_admin")
    public String sortiranje_po_ceniAdmin(Model model) {
        model.addAttribute("artikli", this.artikalService.sortiranjePoCeni());
    
        return "admin_artikli.html";
    }


    @GetMapping("/artikliNaPopustu")
    public String ispisi_artikle_na_popustu(Model model) {
        List<Artikal> artikli_na_popustu=new ArrayList<>();
       
        artikli_na_popustu=this.artikalService.ispisArtikalaNaPopustu();
        model.addAttribute("artikli", artikli_na_popustu);

        return "artikli_neprijavljeni.html";

    }

    @GetMapping("/artikliNaPopustu_kupac")
    public String ispisi_artikle_na_popustuKupac(Model model) {
        List<Artikal> artikli_na_popustu=new ArrayList<>();
       
        artikli_na_popustu=this.artikalService.ispisArtikalaNaPopustu();
        model.addAttribute("artikli", artikli_na_popustu);

        return "artikli_kupac.html";

    }

    @GetMapping("/artikliNaPopustu_admin")
    public String ispisi_artikle_na_popustuAdmin(Model model) {
        List<Artikal> artikli_na_popustu=new ArrayList<>();
       
        artikli_na_popustu=this.artikalService.ispisArtikalaNaPopustu();
        model.addAttribute("artikli", artikli_na_popustu);

        return "admin_artikli.html";

    }

    @PostMapping("/pretraga")
    public String pretrazeni_artikli(Model model, @ModelAttribute("artikal") Artikal artikal1) {
         List<Artikal> artikli = this.artikalService.pretraga_artikala(artikal1);
         model.addAttribute("artikli", artikli);
          return "artikli_neprijavljeni.html"; 
        
        }

        @PostMapping("/pretraga_kupac")
    public String pretrazeni_artikliKupac(Model model, @ModelAttribute("artikal") Artikal artikal1) {
         List<Artikal> artikli = this.artikalService.pretraga_artikala(artikal1);
         model.addAttribute("artikli", artikli);
          return "artikli_kupac.html"; 
        
        }


        @PostMapping("/pretraga_admin")
        public String pretrazeni_artikliAdmin(Model model, @ModelAttribute("artikal") Artikal artikal1) {
             List<Artikal> artikli = this.artikalService.pretraga_artikala(artikal1);
             model.addAttribute("artikli", artikli);
              return "admin_artikli.html"; 
            
            }
    

@GetMapping("/izbrisi_artikal/{id}")
public String izbrisi_artikal(@PathVariable("id") Long id) {
    this.artikalService.izbrisi_artikal(id);

    
    return "redirect:/admin_artikli";
}

List<Artikal> lista_omiljenih=new ArrayList<>();

@GetMapping("/dodaj_u_omiljene/{id}")
public String spisak_omiljenih(@PathVariable("id") Long id,Model model) {

    Artikal omiljeni=this.artikalService.pronadji_artikal_po_id(id);
    lista_omiljenih.add(omiljeni);

    model.addAttribute("artikli", lista_omiljenih);
    
    return "omiljeni_artikli.html";
}

@GetMapping("/dodaj_u_omiljene_kupac/{id}")
public String spisak_omiljenih_Kupac(@PathVariable("id") Long id,Model model) {

    Artikal omiljeni=this.artikalService.pronadji_artikal_po_id(id);
    lista_omiljenih.add(omiljeni);

    model.addAttribute("artikli", lista_omiljenih);
    
    return "omiljeni_artikli_kupac.html";
}

@GetMapping("/dodaj_u_omiljene_admin/{id}")
public String spisak_omiljenih_Admin(@PathVariable("id") Long id,Model model) {

    Artikal omiljeni=this.artikalService.pronadji_artikal_po_id(id);
    lista_omiljenih.add(omiljeni);

    model.addAttribute("artikli", lista_omiljenih);
    
    return "omiljeni_artikli_admin.html";
}

@GetMapping("/omiljeni_artikli") 
public String pogledajOmiljene(Model model) {

    List<Artikal> lista=lista_omiljenih;
   
    model.addAttribute("artikli",lista);
    return "omiljeni_artikli.html";
}

@GetMapping("/omiljeni_artikli_kupac") 
public String pogledajOmiljene_Kupac(Model model) {

    List<Artikal> lista=lista_omiljenih;
   
    model.addAttribute("artikli",lista);
    return "omiljeni_artikli_kupac.html";
}

@GetMapping("/omiljeni_artikli_admin") 
public String pogledajOmiljene_Admin(Model model) {

    List<Artikal> lista=lista_omiljenih;
   
    model.addAttribute("artikli",lista);
    return "omiljeni_artikli_admin.html";
}




    

}


    

    
    

    

