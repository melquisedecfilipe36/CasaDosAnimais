package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Municipio;

@Repository
public interface MunicipioDAO extends JpaRepository<Municipio,Integer> {

}
