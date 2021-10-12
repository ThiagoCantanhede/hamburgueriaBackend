package br.com.hamburgueria;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HamburgueriaApplicationTests {

	@Test
	public void DeveCalcularOValorDeUmX_BaconECompararOValorComOTotalDaSomaDosSeusIngredientes(){
		CardapioController cc = new CardapioController();
		IngredientesController ic = new IngredientesController();
		List<Lanche> lanches = cc.Lanches();
		Double valorXBacon = 0.00;
		Double totalIngredientesXBacon = 0.00;
		
		for(Lanche lanche : lanches) {
			if(lanche.getNome().equals("X-Bacon")) {
				valorXBacon = lanche.calcularTotal();
			}
		}
		
		for(Ingrediente ingrediente : ic.Ingredientes()) {
			if(ingrediente.getNome().equals("Bacon") || 
					ingrediente.getNome().equals("Hambúrguer de carne") || 
					ingrediente.getNome().equals("Queijo")) {
				totalIngredientesXBacon = totalIngredientesXBacon + ingrediente.getValor();
			}
		}
		
		Assert.assertEquals(totalIngredientesXBacon, valorXBacon);
	}
	
	@Test
	public void DeveCalcularOValorDeUmX_BurguerECompararOValorComOTotalDaSomaDosSeusIngredientes(){
		CardapioController cc = new CardapioController();
		IngredientesController ic = new IngredientesController();
		List<Lanche> lanches = cc.Lanches();
		Double valorXBurguer = 0.00;
		Double totalIngredientesXBurguer = 0.00;
		
		for(Lanche lanche : lanches) {
			if(lanche.getNome().equals("X-Burger")) {
				valorXBurguer = lanche.calcularTotal();
			}
		}
		
		for(Ingrediente ingrediente : ic.Ingredientes()) {
			if(ingrediente.getNome().equals("Hambúrguer de carne") || 
					ingrediente.getNome().equals("Queijo")) {
				totalIngredientesXBurguer = totalIngredientesXBurguer + ingrediente.getValor();
			}
		}
		
		Assert.assertEquals(totalIngredientesXBurguer, valorXBurguer);
	}
	
	@Test
	public void DeveCalcularOValorDeUmX_EggECompararOValorComOTotalDaSomaDosSeusIngredientes(){
		CardapioController cc = new CardapioController();
		IngredientesController ic = new IngredientesController();
		List<Lanche> lanches = cc.Lanches();
		Double valorXEgg = 0.00;
		Double totalIngredientesXEgg = 0.00;
		
		for(Lanche lanche : lanches) {
			if(lanche.getNome().equals("X-Egg")) {
				valorXEgg = lanche.calcularTotal();
			}
		}
		
		for(Ingrediente ingrediente : ic.Ingredientes()) {
			if(ingrediente.getNome().equals("Hambúrguer de carne") || 
					ingrediente.getNome().equals("Queijo") || 
					ingrediente.getNome().equals("Ovo")) {
				totalIngredientesXEgg = totalIngredientesXEgg + ingrediente.getValor();
			}
		}
		
		Assert.assertEquals(totalIngredientesXEgg, valorXEgg);
	}	
	
	@Test
	public void DeveCalcularOValorDeUmX_Egg_BaconECompararOValorComOTotalDaSomaDosSeusIngredientes(){
		CardapioController cc = new CardapioController();
		IngredientesController ic = new IngredientesController();
		List<Lanche> lanches = cc.Lanches();
		Double valorXEggBacon = 0.00;
		Double totalIngredientesXEggBacon = 0.00;
		
		for(Lanche lanche : lanches) {
			if(lanche.getNome().equals("X-Egg Bacon")) {
				valorXEggBacon = lanche.calcularTotal();
			}
		}
		
		for(Ingrediente ingrediente : ic.Ingredientes()) {
			if(ingrediente.getNome().equals("Hambúrguer de carne") || 
					ingrediente.getNome().equals("Queijo") || 
					ingrediente.getNome().equals("Ovo") ||
					ingrediente.getNome().equals("Bacon")) {
				totalIngredientesXEggBacon = totalIngredientesXEggBacon + ingrediente.getValor();
			}
		}
		
		Assert.assertEquals(totalIngredientesXEggBacon, valorXEggBacon);
	}	
	
	@Test
	public void DeveCalcularOValorDeUmLanchePersonalizadoLight(){
		IngredientesController ic = new IngredientesController();
		List<Ingrediente> ingredientes = new ArrayList<>();
		Double totalIngredientes = 0.00;
		Double totalComDesconto = 0.00;
		
		for(Ingrediente ingrediente : ic.Ingredientes()) {
			if(ingrediente.getNome().equals("Alface") || 
					ingrediente.getNome().equals("Hambúrguer de carne")) {
				ingredientes.add(ingrediente);
				totalIngredientes = totalIngredientes + ingrediente.getValor();
			}	
		}
		
		totalComDesconto = (totalIngredientes-(totalIngredientes * 0.10));
		
		Lanche lanche = new Lanche("Personalizado", ingredientes);
		
		Assert.assertEquals(totalComDesconto, lanche.calcularTotal());
	}
	
	
	@Test
	public void DeveCalcularOValorDeUmLanchePersonalizadoMuitaCarne(){
		IngredientesController ic = new IngredientesController();
		List<Ingrediente> ingredientes = new ArrayList<>();
		Double valorIndividualCarne = 0.00;
		int quantidadeCotas = 3;
		Double totalComDesconto = 0.00;
		
		for(Ingrediente ingrediente : ic.Ingredientes()) {
			if(ingrediente.getNome().equals("Hambúrguer de carne")) {
				ingrediente.setQuantidade(quantidadeCotas);
				valorIndividualCarne = ingrediente.getValor();
				ingredientes.add(ingrediente);
				break;
			}	
		}
		
		totalComDesconto = (valorIndividualCarne * quantidadeCotas) - 
							((quantidadeCotas / 3) * valorIndividualCarne);
		
		Lanche lanche = new Lanche("Personalizado", ingredientes);
		
		Assert.assertEquals(totalComDesconto, lanche.calcularTotal());
	}
	
	@Test
	public void DeveCalcularOValorDeUmLanchePersonalizadoMuitoQueijo(){
		IngredientesController ic = new IngredientesController();
		List<Ingrediente> ingredientes = new ArrayList<>();
		Double valorIndividualQueijo = 0.00;
		int quantidadeCotas = 3;
		Double totalComDesconto = 0.00;
		
		for(Ingrediente ingrediente : ic.Ingredientes()) {
			if(ingrediente.getNome().equals("Queijo")) {
				ingrediente.setQuantidade(quantidadeCotas);
				valorIndividualQueijo = ingrediente.getValor();
				ingredientes.add(ingrediente);
				break;
			}	
		}
		
		totalComDesconto = (valorIndividualQueijo * quantidadeCotas) - 
							((quantidadeCotas / 3) * valorIndividualQueijo);
		
		Lanche lanche = new Lanche("Personalizado", ingredientes);
		
		Assert.assertEquals(totalComDesconto, lanche.calcularTotal());
	}	
	
}
