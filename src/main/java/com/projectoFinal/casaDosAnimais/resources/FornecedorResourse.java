package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.FornecedorServicos;
import com.projectoFinal.casaDosAnimais.dominio.Fornecedor;

@RestController
@RequestMapping(value="/fornecedores")
public class FornecedorResourse {
	
	@Autowired
	private FornecedorServicos forneceServ;
	

	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Fornecedor> find(@PathVariable Integer id) {
		
		Fornecedor obj = forneceServ.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

	
	
	@DeleteMapping (value="/{id}")
	public void delete(@PathVariable Integer id) {
		
		 forneceServ.apagar(id);
		
	}
}
