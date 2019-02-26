package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.ConsultaServicos;
import com.projectoFinal.casaDosAnimais.dominio.Consulta;

@RestController
@RequestMapping(value="/consulta")
public class ConsultaResourse {
	
	@Autowired
	private ConsultaServicos consultaServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Consulta> find(@PathVariable Integer id) {
		
		Consulta obj = consultaServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
