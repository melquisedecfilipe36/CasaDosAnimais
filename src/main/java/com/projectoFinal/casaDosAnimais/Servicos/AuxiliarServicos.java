package com.projectoFinal.casaDosAnimais.Servicos;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectoFinal.casaDosAnimais.DAO.AuxiliarDAO;
import com.projectoFinal.casaDosAnimais.DAO.MarcacaoDAO;
import com.projectoFinal.casaDosAnimais.DTO.AuxiliarDTO;
import com.projectoFinal.casaDosAnimais.DTO.AuxiliarNewDTO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.DataIntegrityException;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Animal;
import com.projectoFinal.casaDosAnimais.dominio.Auxiliar;
import com.projectoFinal.casaDosAnimais.dominio.Marcacao;
import com.projectoFinal.casaDosAnimais.dominio.TipoMarcacao;
import com.projectoFinal.casaDosAnimais.dominio.Veterinario;


@Service
public class AuxiliarServicos {
		
	@Autowired
	private AuxiliarDAO auxiliarDados;
	
	
	@Autowired
	private MarcacaoDAO marcacaoAuxiliarDados;	
	
	public Auxiliar procurar(Integer id) {
	
		Optional<Auxiliar> obj = auxiliarDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Auxiliar.class.getName()));
	
	}
	
	
	@Transactional
	public Auxiliar inserir(Auxiliar obj) {	
		obj.setId(null);		
		obj= auxiliarDados.save(obj);	
		marcacaoAuxiliarDados.saveAll(obj.getMarcacoes());
		return obj;
	}
	
	
	public Auxiliar actualizar(Auxiliar obj) {	
		Auxiliar newObj = procurar(obj.getId());
		updateData(newObj, obj);
		return  auxiliarDados.save(newObj);	
	}
	
	
	
	public void apagar(Integer id) {
		procurar(id);
		try {
			auxiliarDados.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
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
		return new Auxiliar(objDto.getId(), objDto.getNome(),objDto.getFuncao() ,objDto.getEmail(), null);	
	}

	
	public Auxiliar fromDTO(AuxiliarNewDTO objDto) {
			
			
		Auxiliar auxiliar = new Auxiliar(null,objDto.getNome(),objDto.getEmail(),objDto.getFuncao(),objDto.getDataNascimentoAuxiliar());
		
		Animal animal= new Animal(objDto.getAnimalIdMarcacao(),null,null,null,null,null,null);
		Veterinario veterinario= new Veterinario (objDto.getVeterinarioIdMarcacao(),null,null,null,null,null);
		TipoMarcacao tipoMarcacao = new TipoMarcacao(objDto.getTipoMarcacao(),null);	
		Marcacao marcacao= new Marcacao (null, objDto.getDataMarcacao(),objDto.getObservacaoMarcacao(), auxiliar,tipoMarcacao,veterinario,animal);
		
		auxiliar.getMarcacoes().add(marcacao);
		return auxiliar;
	}
	
	
	private void updateData (Auxiliar newObj, Auxiliar obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	
}
