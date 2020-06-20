package br.com.drogaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.drogaria.domain.Categoria;
import br.com.drogaria.repository.CategoriaRepository;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> listar(){
		List<Categoria> categorias = categoriaRepository.findAll();
		return categorias;
	}
	
	@PostMapping
	public Categoria inserir (@RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		return categoriaSalva;
	}
	
	@DeleteMapping("/{codigo}")
	public Categoria remover (@PathVariable Short codigo) {
		Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(codigo);
		categoriaRepository.delete(categoriaEncontrada.get());
		return categoriaEncontrada.get();
	}
	
	@PutMapping
	public Categoria editar(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
}
