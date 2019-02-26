package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectoFinal.casaDosAnimais.dominio.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente,Integer> {
	
	@Transactional(readOnly=true)
	Cliente findByEmail(String email);

}
