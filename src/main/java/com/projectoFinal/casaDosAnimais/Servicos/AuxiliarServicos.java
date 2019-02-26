package com.projectoFinal.casaDosAnimais.Servicos;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.projectoFinal.casaDosAnimais.DAO.AuxiliarDAO;
import com.projectoFinal.casaDosAnimais.DTO.AuxiliarDTO;

import com.projectoFinal.casaDosAnimais.Servicos.Expetion.DataIntegrityException;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Auxiliar;


@Service
public class AuxiliarServicos {
		
	@Autowired
	private AuxiliarDAO auxiliarDados;
	public Auxiliar procurar(Integer id) {
	
		Optional<Auxiliar> obj = auxiliarDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Auxiliar.class.getName()));
	
	}
	
	public Auxiliar inserir(Auxiliar obj) {
		
		obj.setId(null);
		
		return auxiliarDados.save(obj);
	}
	
	
	public Auxiliar actualizar(Auxiliar obj) {
		
		procurar(obj.getId());
		
		return auxiliarDados.save(obj);
	}
	
	
	
	public void apagar(Integer id) {
		procurar(id);
		try {
			auxiliarDados.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir uma auxiliar que possui marcacoes");
		}
	}
	
	
	public List<Auxiliar> procurarTodos() {
		return auxiliarDados.findAll();
	}
	
	
	public Page<Auxiliar> procurarPagina(Integer pagina, Integer linhasPorPagina, String ordenadoPor, String sentido) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(sentido), ordenadoPor);
		return auxiliarDados.findAll(pageRequest);
	}
	
	public Auxiliar fromDTO(AuxiliarDTO objDto) {
		
		return new Auxiliar (objDto.getId(),objDto.getNome(),objDto.getFuncao(),objDto.getEmail(),null);
		
	}
	
}
