package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Consulta;

@Repository
public interface ConsultaDAO extends JpaRepository<Consulta,Integer> {

}
