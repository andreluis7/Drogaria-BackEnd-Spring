package br.com.drogaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.drogaria.domain.Categoria;
import br.com.drogaria.repository.CategoriaRepository;

public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscarPorCodigo(Short codigo) {
		Optional<Categoria> resultado = categoriaRepository.findById(codigo);
		
		if (resultado.isEmpty()) {
			throw new RuntimeException("Categoria não encontrada!");
		}
		
		Categoria categoria = resultado.get();
		
		return categoria;
	}
	
}
