package com.example.Project.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Korpa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="datum_porudzbine")
    private String datumPorudzbine;

    @Column(name="status")
    private String status;

    @Column(name="kupac")
    private String kupac;
    
    

    @OneToMany(mappedBy="korpa",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private List<Artikal> spisak_kupljenih_artikala=new ArrayList<>();

    @OneToOne
    private Korisnik korisnik;




    public String getKupac() {
        return kupac;
    }

    public void setKupac(String kupac) {
        this.kupac=kupac;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public List<Artikal> getSpisakKupljenihProizvoda() {
        return spisak_kupljenih_artikala;
    }

    public void setSpisakKupljenihProizvoda(List<Artikal> lista) {
        this.spisak_kupljenih_artikala=lista;
    }

    public String getDatumPorudzbine() {
        return datumPorudzbine;
    }

    public void setDatumPorudzbine(String datum) {
        this.datumPorudzbine=datum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status=status;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik=korisnik;
    }



    @Override
    public String toString() {
        return "Korpa{" +
                "id=" + id +
                ", listaKupljenihArtikala=" + spisak_kupljenih_artikala+
                ", datumKupovine=" + datumPorudzbine+
                ", status=" + status +
               
                '}';
    }
    
}
