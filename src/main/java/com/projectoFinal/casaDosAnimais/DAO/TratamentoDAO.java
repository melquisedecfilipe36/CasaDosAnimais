package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Tratamento;

@Repository
public interface TratamentoDAO extends JpaRepository<Tratamento,Integer> {

}
