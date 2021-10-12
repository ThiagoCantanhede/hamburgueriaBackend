package br.com.hamburgueria;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/calcularTotalLanchePersonalizado")
public class LanchePersonalizadoController {
	@CrossOrigin
	@PostMapping
	private Double post(@RequestBody String objeto) throws IOException{
		Lanche lanche = new Lanche();
		lanche = new ObjectMapper().readValue(objeto, Lanche.class);
		
		return lanche.calcularTotal();		
	}

}
