package com.projectoFinal.casaDosAnimais.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.projectoFinal.casaDosAnimais.DTO.AuxiliarDTO;
import com.projectoFinal.casaDosAnimais.DTO.AuxiliarNewDTO;
import com.projectoFinal.casaDosAnimais.Servicos.AuxiliarServicos;
import com.projectoFinal.casaDosAnimais.dominio.Auxiliar;


@RestController
@RequestMapping(value="/auxiliares")
public class AuxiliarResourse {
	
	@Autowired
	private AuxiliarServicos auxiliarServico;
	
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Auxiliar> find(@PathVariable Integer id) {
		
		Auxiliar obj = auxiliarServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AuxiliarNewDTO objDto) {
		Auxiliar obj = auxiliarServico.fromDTO(objDto);
		obj = auxiliarServico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AuxiliarDTO objDto, @PathVariable Integer id) {
		Auxiliar obj = auxiliarServico.fromDTO(objDto);
		obj.setId(id);
		obj = auxiliarServico.actualizar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		auxiliarServico.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AuxiliarDTO>> findAll() {
		List<Auxiliar> list = auxiliarServico.procurarTodos();
		List<AuxiliarDTO> listDto = list.stream().map(obj -> new AuxiliarDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<AuxiliarDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Auxiliar> list = auxiliarServico.procurarPagina(page, linesPerPage, orderBy, direction);
		Page<AuxiliarDTO> listDto = list.map(obj -> new AuxiliarDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}


}
