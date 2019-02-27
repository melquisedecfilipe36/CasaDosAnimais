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


import com.projectoFinal.casaDosAnimais.DAO.CirurgiaDAO;
import com.projectoFinal.casaDosAnimais.DAO.ConsultaDAO;
import com.projectoFinal.casaDosAnimais.DAO.MarcacaoDAO;
import com.projectoFinal.casaDosAnimais.DAO.VacinaDAO;
import com.projectoFinal.casaDosAnimais.DAO.VeterinarioDAO;
import com.projectoFinal.casaDosAnimais.DTO.VeterinarioDTO;
import com.projectoFinal.casaDosAnimais.DTO.VeterinarioNewDTO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.DataIntegrityException;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Animal;
import com.projectoFinal.casaDosAnimais.dominio.Auxiliar;
import com.projectoFinal.casaDosAnimais.dominio.Cirurgia;
import com.projectoFinal.casaDosAnimais.dominio.Consulta;
import com.projectoFinal.casaDosAnimais.dominio.Marcacao;
import com.projectoFinal.casaDosAnimais.dominio.Pagamento;
import com.projectoFinal.casaDosAnimais.dominio.TipoMarcacao;
import com.projectoFinal.casaDosAnimais.dominio.Vacina;
import com.projectoFinal.casaDosAnimais.dominio.Veterinario;

@Service
public class VeterinarioServicos {
	
	 
	
	@Autowired
	private VeterinarioDAO veterinarioDados;
	
	
	@Autowired
	private ConsultaDAO consultaVeterinarioDados;
	
	@Autowired
	private MarcacaoDAO marcacaoVeterinarioDados;	
	
	@Autowired
	private CirurgiaDAO cirurgiaVeterinarioDados;
	
	@Autowired
	private VacinaDAO vacinaVeterinarioDados;
	
	
	public Veterinario procurar(Integer id) {
		
		Optional<Veterinario> obj = veterinarioDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Veterinario.class.getName()));
	
	}
	
	
	
	
	@Transactional
	public Veterinario inserir(Veterinario obj) {	
		obj.setId(null);		
		obj= veterinarioDados.save(obj);
		consultaVeterinarioDados.saveAll(obj.getConsultas());
		marcacaoVeterinarioDados.saveAll(obj.getMarcacoes());
		cirurgiaVeterinarioDados.saveAll(obj.getCirurgias());
		vacinaVeterinarioDados.saveAll(obj.getVacinas());
		return obj;
	}
	
	
	public Veterinario actualizar(Veterinario obj) {	
		Veterinario newObj = procurar(obj.getId());
		updateData(newObj, obj);
		return  veterinarioDados.save(newObj);	
	}
	
	
	
	public void apagar(Integer id) {
		procurar(id);
		try {
			veterinarioDados.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}
	
	
	public List<Veterinario> procurarTodos() {
		return veterinarioDados.findAll();
	}
	
	
	public Page<Veterinario> procurarPagina(Integer pagina, Integer linhasPorPagina, String ordenadoPor, String sentido) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(sentido), ordenadoPor);
		return veterinarioDados.findAll(pageRequest);
	}
	
	public Veterinario fromDTO(VeterinarioDTO objDto) {
		return new Veterinario(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getNumeroDaOrdemDosVeterinarios(),objDto.getEspecialidade(),null);
	}

	
	public Veterinario fromDTO(VeterinarioNewDTO objDto) {
			
		Veterinario veterinario= new Veterinario (null,objDto.getNome(),objDto.getEmail(),objDto.getNumeroDaOrdemDosVeterinarios(), objDto.getEspecialidade(),objDto.getDataNascimentoVeterinario());	
		
		Animal animal= new Animal(objDto.getAnimalIdMarcacao(),null,null,null,null,null,null);
		Auxiliar auxiliar = new Auxiliar (objDto.getAuxiliarIdMarcacao(),null,null,null);
		TipoMarcacao tipoMarcacao = new TipoMarcacao(objDto.getTipoMarcacao(),null);	
		Marcacao marcacao= new Marcacao (null, objDto.getDataMarcacao(),objDto.getObservacaoMarcacao(), auxiliar,tipoMarcacao,veterinario,animal);
		
		Animal animal2= new Animal(objDto.getAnimalIdConsulta(),null,null,null,null,null,null);
		Pagamento pagamento= new Pagamento(objDto.getPagamentoIdConsulta(),null,null,null,null,null);
		Consulta consulta = new Consulta(null,objDto.getDataConsulta(),objDto.getPesoDoAnimalConsulta(),objDto.getObservacaoConsulta(),pagamento,veterinario,animal2);
		
		Cirurgia cirurgia= new Cirurgia(null,objDto.getDescricaoCirurgia(),objDto.getPrecoCirurgia(),veterinario);
		
		Vacina vacina = new Vacina(null,objDto.getDescricaoVacina(),objDto.getIndicacaoVacina(),objDto.getContraIndicacaoVacina(),objDto.getValorVacina(),objDto.getDataValidadeVacina(),veterinario);
		
		veterinario.getMarcacoes().add(marcacao);
		veterinario.getConsultas().add(consulta);
		veterinario.getCirurgias().add(cirurgia);
		veterinario.getVacinas().add(vacina);
		
		return veterinario;
	}
	
	
	private void updateData (Veterinario newObj, Veterinario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	
}
