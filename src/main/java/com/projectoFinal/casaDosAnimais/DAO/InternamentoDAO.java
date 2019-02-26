package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Internamento;

@Repository
public interface InternamentoDAO extends JpaRepository<Internamento,Integer> {

}
