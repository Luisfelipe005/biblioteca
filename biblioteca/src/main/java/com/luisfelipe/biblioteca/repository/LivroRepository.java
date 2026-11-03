package com.luisfelipe.biblioteca.repository;

import com.luisfelipe.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    public List<Livro> findAllBytituloIgnoreCaseContaining(String titulo);
}
