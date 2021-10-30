package com.marcelo.listadecontatos.Lista.de.Contatos.repository;

import com.marcelo.listadecontatos.Lista.de.Contatos.model.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contatos, Long> {

}
