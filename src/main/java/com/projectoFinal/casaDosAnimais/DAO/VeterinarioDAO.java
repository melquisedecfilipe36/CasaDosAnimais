package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.projectoFinal.casaDosAnimais.dominio.Veterinario;

@Repository
public interface VeterinarioDAO extends JpaRepository<Veterinario,Integer> {
	
	
	@Transactional(readOnly=true)
	Veterinario findByEmail(String email);

}
