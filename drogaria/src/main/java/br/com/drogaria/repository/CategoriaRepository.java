package br.com.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.drogaria.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Byte>{

}
