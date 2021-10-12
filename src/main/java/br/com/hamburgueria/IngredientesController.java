package br.com.hamburgueria;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IngredientesController {
	@RequestMapping("/ingredientes")
	@ResponseBody
	public List<Ingrediente> Ingredientes(){
		Ingrediente alface = new Ingrediente("Alface", 0.40);
		Ingrediente bacon = new Ingrediente("Bacon", 2.00);
		Ingrediente hamCarne = new Ingrediente("Hambúrguer de carne", 3.00);
		Ingrediente ovo = new Ingrediente("Ovo", 0.80);
		Ingrediente queijo = new Ingrediente("Queijo", 1.50);
		
		return Arrays.asList(alface, bacon, hamCarne, ovo, queijo);
		
	}

}
