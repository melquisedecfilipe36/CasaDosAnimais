package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.projectoFinal.casaDosAnimais.DAO.ConsultaDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.DataIntegrityException;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Consulta;

@Service
public class ConsultaServicos {
		
	@Autowired
	private ConsultaDAO consultaDados;
	
	
	
	public Consulta procurar(Integer id) {
		
		Optional<Consulta> obj = consultaDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Consulta.class.getName()));
	
	}
	
	public Consulta inserir(Consulta obj) {
		
		obj.setId(null);
		
		return consultaDados.save(obj);
	}
	
	
	public Consulta actualizar(Consulta obj) {
		
		procurar(obj.getId());
		
		return consultaDados.save(obj);
	}
	
	
	
	public void apagar(Integer id) {
		procurar(id);
		try {
			consultaDados.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir uma consulta que possui tratamentos");
		}
	}
	
	
	public List<Consulta> procurarTodos() {
		return consultaDados.findAll();
	}
	
	
	public Page<Consulta> procurarPagina(Integer pagina, Integer linhasPorPagina, String ordenadoPor, String sentido) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(sentido), ordenadoPor);
		return consultaDados.findAll(pageRequest);
	}
	
	
}
