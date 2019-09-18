package com.example.Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KorpaController{



    @GetMapping("/kreirajKorpu")
    public String kreiranje_korpe() {
          return "korpa.html";
    

}
}