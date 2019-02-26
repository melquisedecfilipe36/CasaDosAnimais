package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Raca;

@Repository
public interface RacaDAO extends JpaRepository<Raca,Integer> {

}
