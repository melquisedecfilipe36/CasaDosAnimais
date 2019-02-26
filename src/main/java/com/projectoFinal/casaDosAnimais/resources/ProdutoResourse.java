package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.ProdutoServicos;
import com.projectoFinal.casaDosAnimais.dominio.Produto;

@RestController
@RequestMapping(value="/produto")
public class ProdutoResourse {
	
	@Autowired
	private ProdutoServicos produtoServ;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		
		Produto obj = produtoServ.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
