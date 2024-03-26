package br.mackenzie.restapi.Filme;

import java.util.*;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class FilmeController {
  @Autowired
  private FilmeRepository repository;

  @GetMapping("/filmes")
  public List<Filme> getFilmes() {
    return repository.findAll();
  }

  @GetMapping("/filmes/procurar")
  public List<Filme> getfilmesFromTime(@RequestParam String filme) {
    return repository.findByTituloIgnoreCaseOrAutorIgnoreCase(filme, filme);
  }

  @GetMapping("/filmes/{id}")
  public ResponseEntity<Filme> getFilmeById(@PathVariable long id) {
    Optional<Filme> filme = repository.findById(id);
    if (filme.isPresent()) {
      return ResponseEntity.ok(filme.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/filmes")
  public Filme postNewFilme(@RequestBody Filme filmeBody) {
    Filme novoFilme = new Filme(filmeBody.getTitulo(), filmeBody.getAutor(), filmeBody.getPais(), filmeBody.getEditora(), filmeBody.getAno());
    getFilmes().add(novoFilme);
    return repository.save(novoFilme);
  }

  @PutMapping("/filmes/{id}")
  Optional<Filme> updateFilme(@RequestBody Filme filmeBody, @PathVariable long id) {
    Optional<Filme> opt = repository.findById(id);

    if (opt.isPresent()) {
      Filme filme = opt.get();
      opt.get().setTitulo(filmeBody.getTitulo());
      filme.setAutor(filmeBody.getAutor());
      filme.setPais(filmeBody.getPais());
      filme.setEditora(filmeBody.getEditora());
      repository.save(filme);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    return opt;
  }

  @DeleteMapping("/filmes/{id}")
  void deleteFilme(@PathVariable long id) {
    Optional<Filme> opt = repository.findById(id);
    if(opt.isPresent()){ 
      repository.deleteById(id);
    }else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
   
  }

}
