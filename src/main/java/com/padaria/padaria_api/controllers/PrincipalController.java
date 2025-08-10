package com.padaria.padaria_api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PrincipalController {
    
    @GetMapping("/administrativo")
    public String acessarPrincipal(){
        return "administrativo/casa";
    }
    
}
