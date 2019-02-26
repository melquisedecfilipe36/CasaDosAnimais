package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Medicacao;

@Repository
public interface MedicacaoDAO extends JpaRepository<Medicacao,Integer> {

}
