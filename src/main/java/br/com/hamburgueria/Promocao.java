package br.com.hamburgueria;

import java.util.List;


public class Promocao {
	
	public static boolean isLancheLight(List<Ingrediente> ingredientes) {
		boolean temAlface = false;
		boolean temBacon = false;

		for(Ingrediente ingrediente : ingredientes) {
			if(ingrediente.getNome().equals("Alface")) {
				temAlface = true;
			}
			
			if(ingrediente.getNome().equals("Bacon")) {
				temBacon = true;
			}
		}
		
		return (temAlface && !temBacon);
	}
	
	public static double valorPromocao(int quantidadeCotas, String ingrediente) {
		if(quantidadeCotas>2) {
			double valor = retornarValorDeUmIngrediente(ingrediente);
			return (quantidadeCotas / 3) * valor;
		}else
			return 0.00;
	}
	
	
	private static double retornarValorDeUmIngrediente(String ingrediente) {
		double valor = 0.00;
		IngredientesController IC = new IngredientesController();
		List<Ingrediente> ingredientes = IC.Ingredientes();
		for(Ingrediente i : ingredientes) {
			if(i.getNome().equals(ingrediente)) {
				valor = i.getValor();
			}		
		}
		return valor;
	}
	
	
}
