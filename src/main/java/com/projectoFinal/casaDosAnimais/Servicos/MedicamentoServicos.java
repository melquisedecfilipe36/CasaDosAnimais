package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectoFinal.casaDosAnimais.DAO.MedicamentoDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Medicamento;


@Service
public class MedicamentoServicos { 
	
	@Autowired
	private MedicamentoDAO medicamentoDados;
	
	public Medicamento procurar(Integer id) {
		
		Optional<Medicamento> obj = medicamentoDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Medicamento.class.getName()));
	
	}
	
	public Medicamento inserir(Medicamento obj) {
		
		obj.setId(null);
		
		return medicamentoDados.save(obj);
	}

}
