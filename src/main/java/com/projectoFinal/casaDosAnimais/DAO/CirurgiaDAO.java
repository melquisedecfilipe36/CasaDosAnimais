package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Cirurgia;

@Repository
public interface CirurgiaDAO extends JpaRepository<Cirurgia,Integer> {

}
