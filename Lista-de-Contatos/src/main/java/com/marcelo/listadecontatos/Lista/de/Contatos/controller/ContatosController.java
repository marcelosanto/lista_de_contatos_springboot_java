package com.marcelo.listadecontatos.Lista.de.Contatos.controller;

import com.marcelo.listadecontatos.Lista.de.Contatos.exception.ResourceNotFoundException;
import com.marcelo.listadecontatos.Lista.de.Contatos.model.Contatos;
import com.marcelo.listadecontatos.Lista.de.Contatos.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class ContatosController {

    @Autowired
    private ContatosRepository contatosRepository;

    //get contato byId
    @GetMapping("/contatos/{id}")
    public ResponseEntity<Contatos> getContatoById(@PathVariable Long id) {
        Contatos contato = contatosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contato não existe : " + id));
        return ResponseEntity.ok(contato);
    }

    //get all contatos
    @GetMapping("/contatos")
    public List<Contatos> getAllContatos() {
        return contatosRepository.findAll();
    }

    //add contatos
    @PostMapping("/contatos")
    public Contatos createContato(@RequestBody Contatos contato) {
        return contatosRepository.save(contato);
    }

    // atualizar contato
    @PutMapping("/contatos/{id}")
    public ResponseEntity<Contatos> atualizarContato(@PathVariable Long id, @RequestBody Contatos contatoUpdate) {
        Contatos contato = contatosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contato não existe : " + id));

        contato.setNome(contatoUpdate.getNome());
        contato.setSobrenome(contatoUpdate.getSobrenome());
        contato.setEmailId(contatoUpdate.getEmailId());

        Contatos updateContato = contatosRepository.save(contato);

        return ResponseEntity.ok(updateContato);
    }

    //deleta contato
    @DeleteMapping(path = {"/contatos/{id}"})
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable long id) {
        Contatos contato = contatosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contato não existe : " + id));

        contatosRepository.delete(contato);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
