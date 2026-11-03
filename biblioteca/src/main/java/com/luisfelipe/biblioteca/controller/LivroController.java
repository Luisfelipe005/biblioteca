package com.luisfelipe.biblioteca.controller;

import com.luisfelipe.biblioteca.model.Livro;
import com.luisfelipe.biblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Biblioteca")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> listarLivros(){
        return livroService.listarLivros();
    }

    @GetMapping("/{id}")
    public Livro buscaPorId(@PathVariable Long id){
        return livroService.buscarPorId(id);
    }

    @GetMapping("/titulo")
    public List<Livro> buscaPorTitulo(@Valid @RequestParam String titulo){
        return livroService.buscaPorTitulo(titulo);
    }

    @PostMapping
    public Livro cadastrar(@Valid @RequestBody Livro livro){
        return livroService.cadastrar(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id,@Valid @RequestBody Livro livro){
       return livroService.atualizar(id, livro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        livroService.exclui(id);
    }
}
