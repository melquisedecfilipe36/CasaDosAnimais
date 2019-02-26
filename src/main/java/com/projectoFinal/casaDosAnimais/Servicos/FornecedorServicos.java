package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.FornecedorDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Fornecedor;

@Service
public class FornecedorServicos {
	 
	
	@Autowired
	private FornecedorDAO fornecedorDados;
	
	public Fornecedor procurar(Integer id) {
		
		Optional<Fornecedor> obj = fornecedorDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Fornecedor.class.getName()));
	
	}
	
	public Fornecedor inserir(Fornecedor obj) {
		
		obj.setId(null);
		
		return fornecedorDados.save(obj);
	}
	
	
	public void apagar(Integer id) {
		
		fornecedorDados.deleteById(id);
	}

	
	
}
