package com.example.Project.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.example.Project.entity.Artikal;
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
          List<Artikal> lista_svih_artikala=this.artikalRepository.findAll();
          return lista_svih_artikala;
    }

    @Override
    public List<Artikal> ispisArtikalaPoKategoriji(String kategorija) {
        List<Artikal> oniArtikliKojiOdgovaraju=this.artikalRepository.findAllByKategorija(kategorija);
        return oniArtikliKojiOdgovaraju; 
    }

    @Override 
    public List<Artikal> sortiranjePoNazivu() {
        List<Artikal> artikli_po_nazivu=this.artikalRepository.findAllByOrderByNaziv();
        return artikli_po_nazivu;
    }

    @Override
    public List<Artikal> sortiranjePoId() {
        List<Artikal> artikli_po_id=this.artikalRepository.findAllByOrderById();
        return artikli_po_id;
    }

    @Override
    public List<Artikal> sortiranjePoCeni() {
        List<Artikal> artikli_po_ceni=this.artikalRepository.findAllByOrderByCena();
        return artikli_po_ceni;
    }

    @Override 
    public List<Artikal> ispisArtikalaNaPopustu() {
       List<Artikal> svi_artikli= this.artikalRepository.findAll();

       List<Artikal> na_popustu= new ArrayList<>();

       for(Artikal a: svi_artikli) {
           if(a.getNaPopustu()==true)
           na_popustu.add(a);
       }

       return na_popustu;
    }

 /*   @Override
     public List<Artikal> pretraga_artikala(String unos) {
            List<Artikal> svi_artikli=artikalRepository.findAll();
            List<Artikal> oni_koji_odgovaraju= new ArrayList<>();
            
            
            for(Artikal a: svi_artikli) {
                 if(a.getNaziv().toLowerCase().contains(unos.toLowerCase())) {
                     oni_koji_odgovaraju.add(a);                     
                 }

                 else if(a.getOpisArtikla().toLowerCase().contains(unos.toLowerCase())) {
                    oni_koji_odgovaraju.add(a);
                }

                 else if(a.getOpisArtikla().toLowerCase().contains(unos.toLowerCase())) {
                     oni_koji_odgovaraju.add(a);
                 }

                 else if(a.getKategorija().toLowerCase().contains(unos.toLowerCase())) {
                     oni_koji_odgovaraju.add(a);
                 }

                 else if(Double.toString(a.getCena()).toLowerCase().contains(unos.toLowerCase())) {
                    oni_koji_odgovaraju.add(a);
                }
            
                 else {
                     oni_koji_odgovaraju=null;
                 }
                
                }

                return oni_koji_odgovaraju;
     }

*/



@Override
public void izbrisi_artikal(Long id) {
    this.artikalRepository.deleteById(id);
}
    


}

