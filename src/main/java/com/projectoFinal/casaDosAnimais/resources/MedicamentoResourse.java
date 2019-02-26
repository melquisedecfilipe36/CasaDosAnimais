package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.MedicamentoServicos;
import com.projectoFinal.casaDosAnimais.dominio.Medicamento;

@RestController
@RequestMapping(value="/medicamento")
public class MedicamentoResourse {
	
	@Autowired
	private MedicamentoServicos medicamentoServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Medicamento> find(@PathVariable Integer id) {
		
		Medicamento obj = medicamentoServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
