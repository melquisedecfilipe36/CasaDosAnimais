package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.VeterinarioDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Veterinario;

@Service
public class VeterinarioServicos {
	
	 
	
	@Autowired
	private VeterinarioDAO veterinarioDados;
	
	
	public Veterinario procurar(Integer id) {
		
		Optional<Veterinario> obj = veterinarioDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Veterinario.class.getName()));
	
	}
	
	public Veterinario inserir(Veterinario obj) {
		
		obj.setId(null);
		
		return veterinarioDados.save(obj);
	}
	
	

}
