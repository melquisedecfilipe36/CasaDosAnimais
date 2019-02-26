package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.PagamentoServicos;
import com.projectoFinal.casaDosAnimais.dominio.Pagamento;

@RestController
@RequestMapping(value="/pagamento")
public class PagamentoResourse {
	
	@Autowired
	private PagamentoServicos pagamentoServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Pagamento> find(@PathVariable Integer id) {
		
		Pagamento obj = pagamentoServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
