package com.projectoFinal.casaDosAnimais.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectoFinal.casaDosAnimais.dominio.Veterinario;

@Repository
public interface VeterinarioDAO extends JpaRepository<Veterinario,Integer> {

}
