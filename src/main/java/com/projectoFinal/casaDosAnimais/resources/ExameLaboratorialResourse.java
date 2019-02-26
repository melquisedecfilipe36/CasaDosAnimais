package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.ExameLaboratorialServicos;
import com.projectoFinal.casaDosAnimais.dominio.ExameLaboratorial;

@RestController
@RequestMapping(value="/exameLaboratorial")
public class ExameLaboratorialResourse {
	
	@Autowired
	private ExameLaboratorialServicos exameLaboratorialServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<ExameLaboratorial> find(@PathVariable Integer id) {
		
		ExameLaboratorial obj = exameLaboratorialServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
