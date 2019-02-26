package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.VacinacaoServicos;
import com.projectoFinal.casaDosAnimais.dominio.Vacinacao;

@RestController
@RequestMapping(value="/vacinacao")
public class VacinacaoResourse {
	
	@Autowired
	private VacinacaoServicos vacinacaoServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Vacinacao> find(@PathVariable Integer id) {
		
		Vacinacao obj = vacinacaoServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
