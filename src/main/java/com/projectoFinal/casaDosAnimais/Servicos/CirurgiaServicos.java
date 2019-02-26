package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.CirurgiaDAO;
import com.projectoFinal.casaDosAnimais.DTO.CirurgiaDTO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.DataIntegrityException;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Cirurgia;

@Service
public class CirurgiaServicos {
	
	@Autowired
	private CirurgiaDAO cirurgiaDados;
	public Cirurgia procurar(Integer id) {
		
		Optional<Cirurgia> obj = cirurgiaDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cirurgia.class.getName()));
	
	}
	
	public Cirurgia inserir(Cirurgia obj) {
		
		obj.setId(null);
		
		return cirurgiaDados.save(obj);
	}
	
	
	public Cirurgia actualizar(Cirurgia obj) {
		
		procurar(obj.getId());
		
		return cirurgiaDados.save(obj);
	}
	
	
	
	public void apagar(Integer id) {
		procurar(id);
		try {
			cirurgiaDados.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir uma cirurgia que possui internamentos");
		}
	}
	
	
	public List<Cirurgia> procurarTodos() {
		return cirurgiaDados.findAll();
	}
	
	
	public Page<Cirurgia> procurarPagina(Integer pagina, Integer linhasPorPagina, String ordenadoPor, String sentido) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(sentido), ordenadoPor);
		return cirurgiaDados.findAll(pageRequest);
	}
	
	
	public Cirurgia fromDTO(CirurgiaDTO objDto) {
		
		return new Cirurgia (objDto.getId(),objDto.getDescricao(),objDto.getCusto(),null);
		
	}
	
	
}
