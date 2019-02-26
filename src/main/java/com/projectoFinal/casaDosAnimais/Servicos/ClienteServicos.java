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

import com.projectoFinal.casaDosAnimais.DAO.AnimalDAO;
import com.projectoFinal.casaDosAnimais.DAO.ClienteDAO;
import com.projectoFinal.casaDosAnimais.DAO.EnderecoDAO;
import com.projectoFinal.casaDosAnimais.DTO.ClienteDTO;
import com.projectoFinal.casaDosAnimais.DTO.ClienteNewDTO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.DataIntegrityException;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Animal;
import com.projectoFinal.casaDosAnimais.dominio.Cliente;
import com.projectoFinal.casaDosAnimais.dominio.Endereco;
import com.projectoFinal.casaDosAnimais.dominio.Especie;
import com.projectoFinal.casaDosAnimais.dominio.Municipio;
import com.projectoFinal.casaDosAnimais.dominio.Raca;

@Service
public class ClienteServicos {
	
	
	@Autowired
	private ClienteDAO clienteDados;
	
	
	@Autowired
	private EnderecoDAO enderecoClienteDados;
	
	@Autowired
	private AnimalDAO animalClienteDados;
	
	public Cliente procurar(Integer id) {
		
		Optional<Cliente> obj = clienteDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	
	}
	
	@Transactional
	public Cliente inserir(Cliente obj) {
		
		obj.setId(null);		
		obj= clienteDados.save(obj);		
		enderecoClienteDados.saveAll(obj.getEnderecos());
		animalClienteDados.saveAll(obj.getAnimais());
		
		return obj;
	}
	
	
	public Cliente actualizar(Cliente obj) {	
		Cliente newObj = procurar(obj.getId());
		updateData(newObj, obj);
		return  clienteDados.save(newObj);	
	}
	
	
	
	public void apagar(Integer id) {
		procurar(id);
		try {
			clienteDados.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}
	
	
	public List<Cliente> procurarTodos() {
		return clienteDados.findAll();
	}
	
	
	public Page<Cliente> procurarPagina(Integer pagina, Integer linhasPorPagina, String ordenadoPor, String sentido) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(sentido), ordenadoPor);
		return clienteDados.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null);
	}

	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cliente = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getDataNascimento());
		Municipio municipio = new Municipio(objDto.getMunicipioId(), null,null);
		Endereco endereco = new Endereco(null, objDto.getNumeroDaCasa(), objDto.getRua(), objDto.getBairro(),municipio, cliente);
		Raca raca = new Raca (null,objDto.getDescricaoRaca());
		Especie especie = new Especie(null,objDto.getDescricaoEspecie(),raca);
		Animal animal= new Animal (null,objDto.getNomeAnimal(),objDto.getSexoAnimal(),objDto.getCorAnimal(), objDto.getDataNascimentoAnimal(),especie,cliente);
		cliente.getAnimais().add(animal);
		cliente.getEnderecos().add(endereco);
		cliente.getTelefones().add(objDto.getTelefone1());
		
		if (objDto.getTelefone2()!=null) {
			cliente.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3()!=null) {
			cliente.getTelefones().add(objDto.getTelefone3());
		}
		return cliente;
	}
	
	
	private void updateData (Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	
}
