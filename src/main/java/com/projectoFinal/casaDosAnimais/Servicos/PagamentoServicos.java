package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.PagamentoDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Pagamento;


@Service
public class PagamentoServicos {
	
	 
	
	@Autowired
	private PagamentoDAO pagamentoDados;
	
	public Pagamento procurar(Integer id) {
		
		Optional<Pagamento> obj = pagamentoDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pagamento.class.getName()));
	
	}
	
	public Pagamento inserir(Pagamento obj) {
		
		obj.setId(null);
		
		return pagamentoDados.save(obj);
	}

}
