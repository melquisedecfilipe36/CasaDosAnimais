package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.VacinacaoDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Vacinacao;

@Service
public class VacinacaoServicos {
	
	 
	
	@Autowired
	private VacinacaoDAO vacinacaoDados;
	
	public Vacinacao procurar(Integer id) {
		
		Optional<Vacinacao> obj = vacinacaoDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Vacinacao.class.getName()));
	
	}
	
	public Vacinacao inserir(Vacinacao obj) {
		
		obj.setId(null);
		
		return vacinacaoDados.save(obj);
	}

}
