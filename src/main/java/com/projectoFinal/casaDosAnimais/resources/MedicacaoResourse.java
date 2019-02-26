package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.MedicacaoServicos;
import com.projectoFinal.casaDosAnimais.dominio.Medicacao;

@RestController
@RequestMapping(value="/medicacao")
public class MedicacaoResourse {
	
	@Autowired
	private MedicacaoServicos medicacaoServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Medicacao> find(@PathVariable Integer id) {
		
		Medicacao obj = medicacaoServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
