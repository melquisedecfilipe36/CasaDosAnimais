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


import com.projectoFinal.casaDosAnimais.DTO.VeterinarioDTO;
import com.projectoFinal.casaDosAnimais.DTO.VeterinarioNewDTO;
import com.projectoFinal.casaDosAnimais.Servicos.VeterinarioServicos;

import com.projectoFinal.casaDosAnimais.dominio.Veterinario;

@RestController
@RequestMapping(value="/veterinarios")
public class VeterinarioResourse {
	
	@Autowired
	private VeterinarioServicos veterinarioServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Veterinario> find(@PathVariable Integer id) {
		
		Veterinario obj = veterinarioServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody VeterinarioNewDTO objDto) {
		Veterinario obj = veterinarioServico.fromDTO(objDto);
		obj = veterinarioServico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody VeterinarioDTO objDto, @PathVariable Integer id) {
		Veterinario obj = veterinarioServico.fromDTO(objDto);
		obj.setId(id);
		obj = veterinarioServico.actualizar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		veterinarioServico.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<VeterinarioDTO>> findAll() {
		List<Veterinario> list = veterinarioServico.procurarTodos();
		List<VeterinarioDTO> listDto = list.stream().map(obj -> new VeterinarioDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<VeterinarioDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Veterinario> list = veterinarioServico.procurarPagina(page, linesPerPage, orderBy, direction);
		Page<VeterinarioDTO> listDto = list.map(obj -> new VeterinarioDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}

}
