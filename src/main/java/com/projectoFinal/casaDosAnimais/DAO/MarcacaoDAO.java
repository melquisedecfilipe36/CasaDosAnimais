package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Marcacao;

@Repository
public interface MarcacaoDAO extends JpaRepository<Marcacao,Integer> {

}
