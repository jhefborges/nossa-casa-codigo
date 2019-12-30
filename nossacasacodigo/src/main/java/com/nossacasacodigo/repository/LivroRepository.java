package com.nossacasacodigo.repository;

import org.springframework.stereotype.Repository;

import com.nossacasacodigo.model.livro.Livro;

import org.springframework.data.repository.CrudRepository;

/**
 * LivroRepository
 */
@Repository
public interface LivroRepository extends CrudRepository<Livro,Long>{
}