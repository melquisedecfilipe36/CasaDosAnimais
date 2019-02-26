package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.MunicipioServicos;
import com.projectoFinal.casaDosAnimais.dominio.Municipio;

@RestController
@RequestMapping(value="/municipio")
public class MunicipioResourse {
	
	@Autowired
	private MunicipioServicos municipioServ;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Municipio> find(@PathVariable Integer id) {
		
		Municipio obj = municipioServ.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
