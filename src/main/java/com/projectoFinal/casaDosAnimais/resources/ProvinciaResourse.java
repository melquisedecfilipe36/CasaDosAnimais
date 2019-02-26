package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.ProvinciaServicos;
import com.projectoFinal.casaDosAnimais.dominio.Provincia;

@RestController
@RequestMapping(value="/provincia")
public class ProvinciaResourse {
	
	@Autowired
	private ProvinciaServicos provinciaServ;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Provincia> find(@PathVariable Integer id) {
		
		Provincia obj = provinciaServ.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
