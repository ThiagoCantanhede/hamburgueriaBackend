package br.com.hamburgueria;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CardapioController {

	@RequestMapping("/cardapio")
	@ResponseBody	
	public List<Lanche> Lanches(){
		Lanche xBacon = new Lanche("X-Bacon", Cardapio.montarLanche("X-Bacon"));
		Lanche xBurger = new Lanche("X-Burger", Cardapio.montarLanche("X-Burger"));
		Lanche xEgg = new Lanche("X-Egg", Cardapio.montarLanche("X-Egg"));
		Lanche xEggBacon = new Lanche("X-Egg Bacon", Cardapio.montarLanche("X-Egg Bacon"));
		
		return Arrays.asList(xBacon, xBurger, xEgg, xEggBacon);
		
	}
	
	
}
