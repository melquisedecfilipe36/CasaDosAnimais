package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.MarcacaoServicos;
import com.projectoFinal.casaDosAnimais.dominio.Marcacao;

@RestController
@RequestMapping(value="/marcacao")
public class MarcacaoResourse {
	
	@Autowired
	private MarcacaoServicos marcacaoServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Marcacao> find(@PathVariable Integer id) {
		
		Marcacao obj = marcacaoServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
