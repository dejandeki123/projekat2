package com.example.Project.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.example.Project.entity.Artikal;
import com.example.Project.entity.Korpa;
import com.example.Project.repository.ArtikalRepository;
import com.example.Project.service.ArtikalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtikalServiceImplementation implements ArtikalService {

    @Autowired
    private ArtikalRepository artikalRepository;

    @Override
    public List<Artikal> lista_svih_artikala() {
        List<Artikal> lista_svih_artikala = this.artikalRepository.findAll();
        return lista_svih_artikala;
    }

    @Override
    public List<Artikal> ispisArtikalaPoKategoriji(String kategorija) {
        List<Artikal> oniArtikliKojiOdgovaraju = this.artikalRepository.findAllByKategorija(kategorija);
        return oniArtikliKojiOdgovaraju;
    }

    @Override
    public List<Artikal> sortiranjePoNazivu() {
        List<Artikal> artikli_po_nazivu = this.artikalRepository.findAllByOrderByNaziv();
        return artikli_po_nazivu;
    }

    @Override
    public List<Artikal> sortiranjePoId() {
        List<Artikal> artikli_po_id = this.artikalRepository.findAllByOrderById();
        return artikli_po_id;
    }

    @Override
    public List<Artikal> sortiranjePoCeni() {
        List<Artikal> artikli_po_ceni = this.artikalRepository.findAllByOrderByCena();
        return artikli_po_ceni;
    }

    @Override
    public List<Artikal> ispisArtikalaNaPopustu() {
        List<Artikal> svi_artikli = this.artikalRepository.findAll();

        List<Artikal> na_popustu = new ArrayList<>();

        for (Artikal a : svi_artikli) {
            if (a.getNaPopustu() == true)
                na_popustu.add(a);
        }

        return na_popustu;
    }



    @Override
    public void izbrisi_artikal(Long id) {
        this.artikalRepository.deleteById(id);
    }

    @Override
    public Artikal pronadji_artikal_po_id(Long id) {
        Artikal omiljeni = new Artikal();

        omiljeni = this.artikalRepository.findOneById(id);
        return omiljeni;

    }   

    @Override
    public List<Artikal> pretraga_artikala(Artikal artikal) {
        List<Artikal> trazeni_artikli = new ArrayList<>();
        List<Artikal> artikli = this.artikalRepository.findAll();

        for (Artikal art : artikli) {

            if ( 
                (art.getNaziv().toLowerCase().equals(artikal.getNaziv().toLowerCase()) ||
                (art.getKategorija().toLowerCase().equals(artikal.getKategorija().toLowerCase())))) {
                trazeni_artikli.add(art);   

            }
        }
 
        return trazeni_artikli;
    }

    @Override
    public void ubacivanje_artikla_u_korpu(Korpa korpa,Artikal artikal) {
        artikal.setKorpa(korpa);
        this.artikalRepository.save(artikal);
    }

    @Override 
    public List<Artikal> dobavi_one_u_korpi(Korpa korpa) {
        List<Artikal> dobavljeni=this.artikalRepository.findAllByKorpa(korpa);
        return dobavljeni;
    }

    @Override
    public Artikal kreiraj_artikal(Artikal artikal){
        
        Artikal novi_artikal=this.artikalRepository.save(artikal);
        return novi_artikal;
    }

}
