package com.luisfelipe.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Livro {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @NotBlank(message = "Titulo não pode ser vazio!")
   private String titulo;
    @NotBlank(message = "Categoria não pode ser vazio!")
   private String categoria;
    @NotBlank(message = "Autor não pode ser vazio")
   private String autor;
    @NotNull(message = "Disponivel precisa ser true ou false!")
    private Boolean disponivel;
    @NotNull(message = "Ano de publicação não pode ser vazio!")
   private Integer anoPublicacao;

    public Livro(Long id, String titulo, String categoria, String autor, Boolean disponivel, Integer anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.autor = autor;
        this.disponivel = disponivel;
        this.anoPublicacao = anoPublicacao;
    }

    public Livro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
