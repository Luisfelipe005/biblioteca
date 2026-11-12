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

    public List<Livro> buscaPorDisponibilidade(){
        List<Livro> livros = livroRepository.findAllByDisponivelEqualsTrue();
        if (livros.isEmpty()){
            throw new LivroNaoEncontradoException("Não existem livros na biblioteca ou não existe livros que estejam dísponiveis");
        }
        return livros;
    }

    public List<Livro> buscaPorTitulo(String titulo){
        if(livroRepository.findAllByTituloIgnoreCaseContaining(titulo).isEmpty()){
            throw new LivroNaoEncontradoException("Seu livro com o titulo: "+ titulo +" não foi encontrado");
        }
        return livroRepository.findAllByTituloIgnoreCaseContaining(titulo);
    }

    public List<Livro> buscarPorAutor(String autor){
        if (livroRepository.findAllByAutorIgnoreCaseContaining(autor).isEmpty()) {
            throw new LivroNaoEncontradoException("Seu livro com o autor: " + autor + " não foi encontrado");
        }
        return livroRepository.findAllByAutorIgnoreCaseContaining(autor);
    }

    public List<Livro> buscarPorCategoria(String categoria){
        if(livroRepository.findAllByCategoriaIgnoreCaseContaining(categoria).isEmpty()){
            throw new LivroNaoEncontradoException("Seu livro com a categoria: "+ categoria +" não foi encontrado");
        }
        return livroRepository.findAllByCategoriaIgnoreCaseContaining(categoria);
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
        buscarPorId(id);
        livroRepository.deleteById(id);
    }

}
