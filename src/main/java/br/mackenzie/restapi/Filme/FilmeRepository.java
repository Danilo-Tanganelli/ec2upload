package br.mackenzie.restapi.Filme;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findByTituloIgnoreCaseOrAutorIgnoreCase(String titulo, String autor);
}