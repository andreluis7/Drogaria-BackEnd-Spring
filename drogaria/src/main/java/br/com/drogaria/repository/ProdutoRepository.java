package br.com.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.drogaria.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Short>{

}
