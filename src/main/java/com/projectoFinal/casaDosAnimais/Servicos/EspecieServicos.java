package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.projectoFinal.casaDosAnimais.DAO.EspecieDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.DataIntegrityException;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Especie;

@Service
public class EspecieServicos {
		 
	
	@Autowired
	private EspecieDAO especieDados;
	
	
	public Especie procurar(Integer id) {
		
		Optional<Especie> obj = especieDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Especie.class.getName()));
	
	}
	
	public Especie inserir(Especie obj) {
		
		obj.setId(null);
		
		return especieDados.save(obj);
	}
	
	
	
	public Especie actualizar(Especie obj) {
		
		procurar(obj.getId());
		
		return especieDados.save(obj);
	}
	
	
	
	public void apagar(Integer id) {
		procurar(id);
		try {
			especieDados.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir uma Especie que possui Raca");
		}
	}
	
	
	public List<Especie> procurarTodos() {
		return especieDados.findAll();
	}
	
	
	public Page<Especie> procurarPagina(Integer pagina, Integer linhasPorPagina, String ordenadoPor, String sentido) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(sentido), ordenadoPor);
		return especieDados.findAll(pageRequest);
	}
	
}
