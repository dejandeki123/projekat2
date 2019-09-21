package com.example.Project.service.implementation;

import com.example.Project.entity.Korpa;
import com.example.Project.repository.KorpaRepository;
import com.example.Project.service.KorpaService;

import org.springframework.stereotype.Service;

@Service
public class KorpaServiceImplementation implements KorpaService{
    private KorpaRepository korpaRepository;
    
    @Override
    public void kreiraj_korpu(Korpa korpa) {
             Korpa kreirana_korpa=new Korpa();
             kreirana_korpa=this.korpaRepository.save(korpa);
           
            }
}