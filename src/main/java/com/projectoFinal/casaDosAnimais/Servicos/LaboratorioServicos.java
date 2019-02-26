package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectoFinal.casaDosAnimais.DAO.LaboratorioDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Laboratorio;

@Service
public class LaboratorioServicos { 
	
	@Autowired
	private LaboratorioDAO laboratorioDados;
	
	
	public Laboratorio procurar(Integer id) {
		
		Optional<Laboratorio> obj = laboratorioDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Laboratorio.class.getName()));
	
	}
	
	public Laboratorio inserir(Laboratorio obj) {
		
		obj.setId(null);
		
		return laboratorioDados.save(obj);
	}
}
