package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Pagamento;


@Repository
public interface PagamentoDAO extends JpaRepository<Pagamento,Integer> {

}
