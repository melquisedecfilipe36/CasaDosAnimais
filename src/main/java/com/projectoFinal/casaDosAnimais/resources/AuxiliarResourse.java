package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.AuxiliarServicos;
import com.projectoFinal.casaDosAnimais.dominio.Auxiliar;

@RestController
@RequestMapping(value="/auxiliar")
public class AuxiliarResourse {
	
	@Autowired
	private AuxiliarServicos auxiliarServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Auxiliar> find(@PathVariable Integer id) {
		
		Auxiliar obj = auxiliarServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
