package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.VeterinarioServicos;
import com.projectoFinal.casaDosAnimais.dominio.Veterinario;

@RestController
@RequestMapping(value="/veterinario")
public class VeterinarioResourse {
	
	@Autowired
	private VeterinarioServicos veterinarioServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Veterinario> find(@PathVariable Integer id) {
		
		Veterinario obj = veterinarioServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
