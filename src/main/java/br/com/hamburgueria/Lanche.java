package br.com.hamburgueria;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Lanche {
	private String nome;
	
	@JsonProperty("ingredientes")
	private List<Ingrediente> ingredientes;
	
	private Double valor;
	
	public Lanche(String nome, List<Ingrediente> ingredientes) {
		this.nome = nome;
		this.ingredientes = ingredientes;
	}
	
	public Lanche() {
		
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Double getValor() {
		valor = this.calcularTotal();
		return valor;
	}
	
	public Double calcularTotal() {
		Double total = 0.00;
		
		if(this.getNome().equals("Personalizado")) {
			total = this.calcularTotalPersonalizado();
		}else {
			total = this.calcularTotalDeTodosOsIngredientes();
		}
		
		return total;
	}
	
	private Double calcularTotalDeTodosOsIngredientes() {
		Double total = 0.00;
		for(Ingrediente ingrediente : ingredientes) {
			total = (ingrediente.getValor() * ingrediente.getQuantidade()) + total;
		}
		
		return total;
	}
	
	private Double calcularTotalPersonalizado() {
		Double total = 0.00;
		int desconto = 0;
		
		if(Promocao.isLancheLight(ingredientes)) {
			desconto = 10;
		}
		
		total = this.calcularTotalDeTodosOsIngredientes();
		
		total = total - Promocao.valorPromocao(retornarQuantidadeCotasIngrediente("Hambúrguer de carne"), "Hambúrguer de carne");
		
		total = total - Promocao.valorPromocao(retornarQuantidadeCotasIngrediente("Queijo"), "Queijo");
		
		return total - (total*((double)desconto/100));
	}
	
	private int retornarQuantidadeCotasIngrediente(String ingrediente) {
		int contador = 0;
		for(Ingrediente i : ingredientes) {
			if(i.getNome().equals(ingrediente)) {
				contador = i.getQuantidade();
				break;
			}		
		}
			
		return contador;
	}

}
