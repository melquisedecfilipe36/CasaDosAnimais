package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.projectoFinal.casaDosAnimais.DAO.AnimalDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.DataIntegrityException;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Animal;



@Service
public class AnimalServicos {
	
	@Autowired
	private AnimalDAO animalDados;
	public Animal procurar(Integer id) {	
			
		Optional<Animal> obj = animalDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Animal.class.getName()));
	
	}
	

	public Animal inserir(Animal obj) {
		
		obj.setId(null);
		
		return animalDados.save(obj);
	}
	
	public Animal actualizar(Animal obj) {
		
		procurar(obj.getId());
		
		return animalDados.save(obj);
	}
	
	
	
	public void apagar(Integer id) {
		procurar(id);
		try {
			animalDados.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir um animal que possui consultas e marcaoes");
		}
	}
	
	
	public List<Animal> procurarTodos() {
		return animalDados.findAll();
	}
	
	
	public Page<Animal> procurarPagina(Integer pagina, Integer linhasPorPagina, String ordenadoPor, String sentido) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(sentido), ordenadoPor);
		return animalDados.findAll(pageRequest);
	}
	
}
