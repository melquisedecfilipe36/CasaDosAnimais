package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.MunicipioDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Municipio;

@Service
public class MunicipioServicos {
	
	 
	
	@Autowired
	private MunicipioDAO municipioDados;
	
	public Municipio procurar(Integer id) {
		
		Optional<Municipio> obj = municipioDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Municipio.class.getName()));
	
	}
	
	public Municipio inserir(Municipio obj) {
		
		obj.setId(null);
		
		return municipioDados.save(obj);
	}

}
