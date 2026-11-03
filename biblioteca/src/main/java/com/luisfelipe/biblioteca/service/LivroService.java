package com.luisfelipe.biblioteca.service;

import com.luisfelipe.biblioteca.exception.LivroNaoEncontradoException;
import com.luisfelipe.biblioteca.model.Livro;
import com.luisfelipe.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro cadastrar(Livro livro){
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros(){
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Long id){
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new LivroNaoEncontradoException("Seu livro não foi encontrado"));
        return livro;
    }

    public List<Livro> buscaPorTitulo(String titulo){
        if(livroRepository.findAllBytituloIgnoreCaseContaining(titulo).isEmpty()){
            throw new LivroNaoEncontradoException("Seu livro com o titulo: "+ titulo +" não foi encontrado");
        }
        return livroRepository.findAllBytituloIgnoreCaseContaining(titulo);
    }

    public Livro atualizar(Long id, Livro livro){
        Livro aux = buscarPorId(id);

        aux.setAnoPublicacao(livro.getAnoPublicacao());
        aux.setAutor(livro.getAutor());
        aux.setCategoria(livro.getCategoria());
        aux.setDisponivel(livro.isDisponivel());
        aux.setTitulo(livro.getTitulo());

        livroRepository.save(aux);
        return aux;
    }

    public void exclui(Long id){
        livroRepository.deleteById(id);
    }

}
