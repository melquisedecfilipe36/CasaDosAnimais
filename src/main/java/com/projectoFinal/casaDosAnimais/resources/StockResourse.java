package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.StockServicos;
import com.projectoFinal.casaDosAnimais.dominio.Stock;

@RestController
@RequestMapping(value="/stock")
public class StockResourse {
	
	@Autowired
	private StockServicos stockServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Stock> find(@PathVariable Integer id) {
		
		Stock obj = stockServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
