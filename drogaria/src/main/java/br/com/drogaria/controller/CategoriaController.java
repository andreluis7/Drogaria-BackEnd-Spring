package br.com.drogaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.drogaria.domain.Categoria;
import br.com.drogaria.exception.RecursoNaoEncontradoException;
import br.com.drogaria.repository.CategoriaRepository;
import br.com.drogaria.service.CategoriaService;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public List<Categoria> listar(){
		List<Categoria> categorias = categoriaService.listar();
		return categorias;
	}
	
	@GetMapping("/{codigo}")
	public Categoria buscarPorCodigo(@PathVariable Short codigo) {
		try {
		Categoria categoria = categoriaService.buscarPorCodigo(codigo);
		return categoria;
		}catch (RecursoNaoEncontradoException erro) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada!", erro);
		}
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
