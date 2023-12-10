package com.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.model.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Integer>{
	
}
