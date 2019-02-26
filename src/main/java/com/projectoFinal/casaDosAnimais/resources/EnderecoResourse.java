package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.EnderecoServicos;
import com.projectoFinal.casaDosAnimais.dominio.Endereco;

@RestController
@RequestMapping(value="/endereco")
public class EnderecoResourse {
	
	@Autowired
	private EnderecoServicos enderecoServ;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Endereco> find(@PathVariable Integer id) {
		
		Endereco obj = enderecoServ.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
