package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.TipoMarcacao;

@Repository
public interface TipoMarcacaoDAO extends JpaRepository<TipoMarcacao,Integer> {

}
