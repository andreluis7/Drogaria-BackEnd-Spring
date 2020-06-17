package br.com.drogaria.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
	
	private Short codigo;
	
	private String nome;
	
	private Byte quantidade;
	
	private BigDecimal preco;
	
	private LocalDate dataDeValidade;

}
