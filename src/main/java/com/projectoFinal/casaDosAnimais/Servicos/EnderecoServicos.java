package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.projectoFinal.casaDosAnimais.DAO.EnderecoDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.DataIntegrityException;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Endereco;

@Service
public class EnderecoServicos {
		
	@Autowired
	private EnderecoDAO enderecoDados;
	
	public Endereco procurar(Integer id) {
		
		Optional<Endereco> obj = enderecoDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	
	}
	
	public Endereco inserir(Endereco obj) {
		
		obj.setId(null);
		
		return enderecoDados.save(obj);
	}
	
	public Endereco actualizar(Endereco obj) {
		
		procurar(obj.getId());
		
		return enderecoDados.save(obj);
	}
	
	
	
	public void apagar(Integer id) {
		procurar(id);
		try {
			enderecoDados.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir um Endereco que possui municipios");
		}
	}
	
	
	public List<Endereco> procurarTodos() {
		return enderecoDados.findAll();
	}
	
	
	public Page<Endereco> procurarPagina(Integer pagina, Integer linhasPorPagina, String ordenadoPor, String sentido) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(sentido), ordenadoPor);
		return enderecoDados.findAll(pageRequest);
	}
	
	
}
