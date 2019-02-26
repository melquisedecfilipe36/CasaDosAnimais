package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.ExameLaboratorial;

@Repository
public interface ExameLaboratorialDAO extends JpaRepository<ExameLaboratorial,Integer> {

}
