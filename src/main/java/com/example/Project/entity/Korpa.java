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
    private Status status;

    

    @OneToMany(mappedBy="korpa",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    List<Artikal> spisak_kupljenih_artikala=new ArrayList<Artikal>();

    
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status=status;
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