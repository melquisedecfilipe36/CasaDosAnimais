package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Endereco;

@Repository
public interface EnderecoDAO extends JpaRepository<Endereco,Integer> {

}
