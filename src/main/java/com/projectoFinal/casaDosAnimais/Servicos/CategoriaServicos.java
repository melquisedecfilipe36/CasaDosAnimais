package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.projectoFinal.casaDosAnimais.DAO.CategoriaDAO;
import com.projectoFinal.casaDosAnimais.DTO.CategoriaDTO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.DataIntegrityException;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Categoria;



@Service
public class CategoriaServicos {
		
	@Autowired
	private CategoriaDAO categoriaDados;
	
	
	
	public Categoria procurar(Integer id) {
		Optional<Categoria> obj = categoriaDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria inserir(Categoria obj) {
		
		obj.setId(null);
		
		return categoriaDados.save(obj);
	}
	
	
	public Categoria actualizar(Categoria obj) {
		
		Categoria newObj = procurar(obj.getId());
		updateData(newObj, obj);
		return categoriaDados.save(newObj);
	}
	
	public void apagar(Integer id) {
		procurar(id);
		try {
			categoriaDados.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	
	public List<Categoria> procurarTodos() {
		return categoriaDados.findAll();
	}
	
	
	public Page<Categoria> procurarPagina(Integer pagina, Integer linhasPorPagina, String ordenadoPor, String sentido) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(sentido), ordenadoPor);
		return categoriaDados.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO objDto) {
		
		return new Categoria (objDto.getId(),objDto.getNome());	
	}
	
	private void updateData (Categoria newObj,Categoria obj) {
		newObj.setNome(obj.getNome());
	}
}
