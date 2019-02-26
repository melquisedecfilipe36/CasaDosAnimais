package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.AnimalServicos;
import com.projectoFinal.casaDosAnimais.dominio.Animal;

@RestController
@RequestMapping(value="/animal")
public class AnimalResourse {
	
	@Autowired
	private AnimalServicos animalServ;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Animal> find(@PathVariable Integer id) {
		
		Animal obj = animalServ.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
