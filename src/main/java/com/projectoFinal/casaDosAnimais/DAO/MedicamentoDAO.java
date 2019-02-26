package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Medicamento;

@Repository
public interface MedicamentoDAO extends JpaRepository<Medicamento,Integer> {

}
