package br.com.drogaria.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.drogaria.domain.Produto;

@SpringBootTest
public class ProdutoRepositoryTests {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Test
	public void inserir() {
		Produto p1 = new Produto( null,
			      "Coca-Cola", 
				  Byte.valueOf("15"), 
				  BigDecimal.valueOf(10.50),
				  LocalDate.of(2020, 6, 16),
				  null);
		
		Produto p2 = new Produto( null,
			      "Fanta", 
				  Byte.valueOf("10"), 
				  BigDecimal.valueOf(12.70),
				  LocalDate.of(2020, 6, 17),
				  null);
		
		produtoRepository.save(p1);
		produtoRepository.save(p2);
	}
}
