package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.StockDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Stock;


@Service
public class StockServicos {
	
	 
	
	@Autowired
	private StockDAO stockDados;
	
	public Stock procurar(Integer id) {
		
		Optional<Stock> obj = stockDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Stock.class.getName()));
	
	}
	
	public Stock inserir(Stock obj) {
		
		obj.setId(null);
		
		return stockDados.save(obj);
	}
	
}
