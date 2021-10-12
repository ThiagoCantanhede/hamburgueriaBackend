package br.com.hamburgueria;


public class Ingrediente {
	private String nome;
	private Double valor;
	private int quantidade;
	
	public Ingrediente(String nome, Double valor) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = 1;
	}
	
	public Ingrediente() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void  setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}	
}
