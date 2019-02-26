package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.ProdutoDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Produto;

@Service
public class ProdutoServicos {
	
	 
	
	@Autowired
	private ProdutoDAO produtoDados;
	
	public Produto procurar(Integer id) {
		
		Optional<Produto> obj = produtoDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	
	}
	
	public Produto inserir(Produto obj) {
		
		obj.setId(null);
		
		return produtoDados.save(obj);
	}
}
