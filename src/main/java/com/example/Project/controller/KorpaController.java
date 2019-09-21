package com.example.Project.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.Project.entity.Artikal;
import com.example.Project.entity.Korpa;
import com.example.Project.service.ArtikalService;
import com.example.Project.service.KorpaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class KorpaController {

    private KorpaService korpaService;

    private ArtikalService artikalService;

   /* @GetMapping("/kreirajKorpu")
    public String kreiranje_korpe(Model model) {

        model.addAttribute("nova_korpa", this.novaKorpa.getSpisakKupljenihProizvoda());
        return "korpa.html";
    }*/

  /*  @GetMapping("/dodaj_u_korpu/{id}")
    public String dodavanje_u_korpu(@PathVariable("id") Long id, Model model) {

        
        Artikal jedan_artikal = this.artikalService.pronadji_artikal_po_id(id);
        lista_proizvoda_u_korpi.add(jedan_artikal);

        novaKorpa.setSpisakKupljenihProizvoda(lista_proizvoda_u_korpi);
        model.addAttribute("nova_korpa", novaKorpa.getSpisakKupljenihProizvoda());

        return "korpa.html";
    }*/

}