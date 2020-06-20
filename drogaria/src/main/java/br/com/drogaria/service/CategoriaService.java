package br.com.drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.drogaria.domain.Categoria;
import br.com.drogaria.exception.RecursoNaoEncontradoException;
import br.com.drogaria.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscarPorCodigo(Short codigo) {
		Optional<Categoria> resultado = categoriaRepository.findById(codigo);
		
		if (resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		
		Categoria categoria = resultado.get();
		
		return categoria;
	}
	
	public List<Categoria> listar(){
		List<Categoria> categorias = categoriaRepository.findAll();
		return categorias;
	}
	
}
