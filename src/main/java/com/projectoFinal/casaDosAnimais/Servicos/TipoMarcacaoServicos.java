package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.TipoMarcacaoDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.TipoMarcacao;


@Service
public class TipoMarcacaoServicos {
	
	 
	
	@Autowired
	private TipoMarcacaoDAO tipoMarcacaoDados;
	
	public TipoMarcacao procurar(Integer id) {
		
		Optional<TipoMarcacao> obj = tipoMarcacaoDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoMarcacao.class.getName()));
	
	}
	
	public TipoMarcacao inserir(TipoMarcacao obj) {
		
		obj.setId(null);
		
		return tipoMarcacaoDados.save(obj);
	}

}
