package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Vacinacao;

@Repository
public interface VacinacaoDAO extends JpaRepository<Vacinacao,Integer> {

}
