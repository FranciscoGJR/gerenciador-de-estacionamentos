package com.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gerenciador.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{

	@Query(value = "SELECT ESTABELECIMENTO_IDENTIFICADOR WHERE VEICULO FROM VEICULO_IDENTIFICADOR = :identificadorVeiculo", nativeQuery = true)
	Integer buscarVeiculosEmEstacionamento(@Param("identificadorVeiculo") Integer identificadorVeiculo);
	
}
