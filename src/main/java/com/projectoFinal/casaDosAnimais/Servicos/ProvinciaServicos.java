package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.ProvinciaDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Provincia;

@Service
public class ProvinciaServicos {
	
	 
	
	@Autowired
	private ProvinciaDAO provinciaDados;
	
	
	public Provincia procurar(Integer id) {
		
		Optional<Provincia> obj = provinciaDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Provincia.class.getName()));
	
	}
	
	public Provincia inserir(Provincia obj) {
		
		obj.setId(null);
		
		return provinciaDados.save(obj);
	}
}
