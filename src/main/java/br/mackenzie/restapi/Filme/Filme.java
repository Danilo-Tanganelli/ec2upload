package br.mackenzie.restapi.Filme;


import javax.persistence.*;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;



@Entity
@Table(name="filmes")
public class Filme {



@GeneratedValue
@javax.persistence.Id
private long id;
  private int ano;
  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  
  private String titulo;
  private String autor;
  private String pais;
  private String editora;
  private int likes;
  private int dislikes;


  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getEditora() {
    return editora;
  }

  public void setEditora(String editora) {
    this.editora = editora;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public int getLikes() {
    return likes
;
  }

  public void setLikes(int likes) {
    this.likes
 = likes
;
  }

  public int getDislikes() {
    return dislikes
;
  }

  public void setDislikes(int dislikes) {
    this.dislikes
 = dislikes
;
  }

  public Filme() {
    titulo = "";
  }

  public Filme(String titulo, String autor, String pais, String editora, int ano) {
    this.titulo = titulo;
    this.autor = autor;
    this.pais = pais;
    this.editora = editora;
    this.ano = ano;
    

  }


  // public String toString() {
  //   return "Aluno " + nome + ", TIA: " + id;
  // }
}