package com.example.Project.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Artikal implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="naziv")
    private String naziv;


    @Column(name="opisartikla")
    private String opisArtikla;
    
    
    @Column(name="cena")
    private double cena;
    
    
    
    @Column(name="kolicina")
    private int kolicina;
    
    
    
    @Column(name="kategorija")
    private String kategorija;
    
    
    @Column(name = "napopustu")
    private Boolean naPopustu;

    
    @Column(name = "omiljeniartikal")
    private Boolean omiljeniArtikal;

    @ManyToOne
    private Korpa korpa;

    public Boolean getOmiljeniArtikal() {
        return omiljeniArtikal;
    }
    public void setOmiljen(Boolean omiljen) {
        this.omiljeniArtikal = omiljen;
    }


    
     public Boolean getNaPopustu() {
        return naPopustu;
    }

    public void setNaPopustu(Boolean popust) {
        this.naPopustu = popust;
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }



    public Korpa getKorpa() {
        return korpa;
    }

    public void setKorpa(Korpa korpa) {
        this.korpa=korpa;
    }


    public String getOpisArtikla() {
        return opisArtikla;
    }

    public void setOpisArtikla(String opisArtikla) {
        this.opisArtikla = opisArtikla;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public Long getId() {
        return id;
    }
    

    public void setId(Long id) {
        this.id = id;
    }

   

    @Override
    public String toString() {
        return "ArtikalRepository{" +
                "naziv='" + naziv + '\'' +
                ", opisArtikla='" + opisArtikla + '\'' +
                ", cena=" + cena +
                ", kolicina=" + kolicina +
                ", kategorija='" + kategorija + '\'' +
                '}';
    }
}