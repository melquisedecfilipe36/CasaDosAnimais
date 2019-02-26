package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.ExameLaboratorialDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.DataIntegrityException;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.ExameLaboratorial;

@Service
public class ExameLaboratorialServicos {
	
	 
	
	@Autowired
	private ExameLaboratorialDAO exameLaboratorialDados;
	
	public ExameLaboratorial procurar(Integer id) {
		
		Optional<ExameLaboratorial> obj = exameLaboratorialDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ExameLaboratorial.class.getName()));
	
	}
	
	public ExameLaboratorial inserir(ExameLaboratorial obj) {
		
		obj.setId(null);
		
		return exameLaboratorialDados.save(obj);
	}
	
	
	
	public void apagar(Integer id) {
		procurar(id);
		try {
			exameLaboratorialDados.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	
	public List<ExameLaboratorial> procurarTodos() {
		return exameLaboratorialDados.findAll();
	}
	
	
	public Page<ExameLaboratorial> procurarPagina(Integer pagina, Integer linhasPorPagina, String ordenadoPor, String sentido) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(sentido), ordenadoPor);
		return exameLaboratorialDados.findAll(pageRequest);
	}
	

}
