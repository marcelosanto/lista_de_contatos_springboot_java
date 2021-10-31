package com.marcelo.listadecontatos.Lista.de.Contatos.controller;

import com.marcelo.listadecontatos.Lista.de.Contatos.model.Contatos;
import com.marcelo.listadecontatos.Lista.de.Contatos.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class ContatosController {

    @Autowired
    private ContatosRepository contatosRepository;

    //get all contatos
    @GetMapping("/contatos")
    public List<Contatos> getAllContatos() {
        return contatosRepository.findAll();
    }
}
