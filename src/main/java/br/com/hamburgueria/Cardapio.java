package br.com.hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
	public static List<Ingrediente> montarLanche(String nomeLanche){
		List<Ingrediente> listaIngredientes = new IngredientesController().Ingredientes();
		List<Ingrediente> ingredientesRetorno = new ArrayList<>(); 
		
		if(nomeLanche.equals("X-Bacon")) {
			for(Ingrediente ingrediente : listaIngredientes) {
				if(ingrediente.getNome().equals("Bacon") || 
						ingrediente.getNome().equals("Hambúrguer de carne") ||
						ingrediente.getNome().equals("Queijo")) {
					
					ingredientesRetorno.add(ingrediente);
				}
			}
		}

		if(nomeLanche.equals("X-Burger")) {
			for(Ingrediente ingrediente : listaIngredientes) {
				if(ingrediente.getNome().equals("Hambúrguer de carne") ||
					ingrediente.getNome().equals("Queijo")) {
					
					ingredientesRetorno.add(ingrediente);
				}
			}
		}
		
		if(nomeLanche.equals("X-Egg")) {
			for(Ingrediente ingrediente : listaIngredientes) {
				if(ingrediente.getNome().equals("Ovo") || 
						ingrediente.getNome().equals("Hambúrguer de carne") ||
						ingrediente.getNome().equals("Queijo")) {
					
					ingredientesRetorno.add(ingrediente);
				}
			}
		}
		
		if(nomeLanche.equals("X-Egg Bacon")) {
			for(Ingrediente ingrediente : listaIngredientes) {
				if(ingrediente.getNome().equals("Bacon") || 
						ingrediente.getNome().equals("Ovo") ||
						ingrediente.getNome().equals("Hambúrguer de carne") ||
						ingrediente.getNome().equals("Queijo")) {
					
					ingredientesRetorno.add(ingrediente);
				}
			}
		}
		
		return ingredientesRetorno;
	}

}
