package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.TratamentoServicos;
import com.projectoFinal.casaDosAnimais.dominio.Tratamento;

@RestController
@RequestMapping(value="/tratamento")
public class TratamentoResourse {
	
	@Autowired
	private TratamentoServicos tratamentoServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Tratamento> find(@PathVariable Integer id) {
		
		Tratamento obj = tratamentoServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
