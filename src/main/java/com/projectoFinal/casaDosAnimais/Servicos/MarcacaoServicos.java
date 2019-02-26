package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectoFinal.casaDosAnimais.DAO.MarcacaoDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Marcacao;

@Service
public class MarcacaoServicos {
		
	@Autowired
	private MarcacaoDAO marcacaoDados;
	
	public Marcacao procurar(Integer id) {
		
		Optional<Marcacao> obj = marcacaoDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Marcacao.class.getName()));
	
	}
	
	public Marcacao inserir(Marcacao obj) {
		
		obj.setId(null);
		
		return marcacaoDados.save(obj);
	}

}
