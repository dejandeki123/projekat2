package com.example.Project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Korisnik")
public class Korisnik implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="korisnickoime")
    private String korisnickoIme;

    @Column(name="lozinka")
    private String lozinka;

    @Column(name="ime")
    private String ime;

    @Column(name="prezime")
    private String prezime;

    @Column(name="uloga")
    private Uloga uloga;

    @Column(name="kontakttelefon")
    private int kontaktTelefon;

    @Column(name="email")
    private String email;

    @Column(name="adresa")
    private String adresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme=korisnickoIme;
    }

    public String getLozinka() {
         return lozinka;
     }

    public void setLozinka(String lozinka) {
        this.lozinka=lozinka;
    }

    public String getIme() {
        return ime;
    }    

    public void setIme(String ime) {
        this.ime=ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime=prezime;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga=uloga;
    }
    
    public int getTelefon() {
        return kontaktTelefon;
    }

    public void setTelefon(int telefon) {
        this.kontaktTelefon=telefon;
    }

    public String getMail() {
        return email;
    }

    public void setMail(String mail) {
        this.email=mail;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa=adresa;
    }

    public Korisnik() {

    }

    public Korisnik(Long id,String korisnickoIme,String lozinka,String ime,String prezime,Uloga uloga,int telefon,String email,String adresa){
        this.id=id;
        this.korisnickoIme=korisnickoIme;
        this.lozinka=lozinka;
        this.ime=ime;
        this.prezime=prezime;
        this.uloga=uloga;
        this.email=email;
        this.kontaktTelefon=telefon;
        this.adresa=adresa;
    }
  
    @Override
    public String toString() {
        return "Kupac{" +
                "korisnickoIme='" + korisnickoIme + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", uloga='" + uloga + '\'' +
                ", telefon=" + kontaktTelefon +
                ", mail='" + email + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
