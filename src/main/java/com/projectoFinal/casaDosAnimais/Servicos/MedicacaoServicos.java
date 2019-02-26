package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.MedicacaoDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Medicacao;


@Service
public class MedicacaoServicos {
	
	 
	
	@Autowired
	private MedicacaoDAO medicacaoDados;
	
	public Medicacao procurar(Integer id) {
		
		Optional<Medicacao> obj = medicacaoDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Medicacao.class.getName()));
	
	}
	
	public Medicacao inserir(Medicacao obj) {
		
		obj.setId(null);
		
		return medicacaoDados.save(obj);
	}

}
