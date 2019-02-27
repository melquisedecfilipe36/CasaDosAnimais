package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectoFinal.casaDosAnimais.dominio.Auxiliar;

@Repository
public interface AuxiliarDAO extends JpaRepository<Auxiliar,Integer> {
	
	@Transactional(readOnly=true)
	Auxiliar findByEmail(String email);

}
