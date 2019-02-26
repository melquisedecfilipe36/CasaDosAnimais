package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Vacina;

@Repository
public interface VacinaDAO extends JpaRepository<Vacina,Integer> {

}
