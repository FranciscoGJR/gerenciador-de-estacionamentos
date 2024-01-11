package com.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gerenciador.model.EntradaSaidaVeiculo;
import com.gerenciador.model.Veiculo;

public interface EntradaSaidaVeiculoRepository extends JpaRepository<EntradaSaidaVeiculo, Integer>{

	@Query(value = "SELECT ID_ENTRADA_SAIDA_VEICULO FROM ENTRADA_SAIDA_VEICULO WHERE ENTRADA_SAIDA_VEICULO.ID_ESTACIONAMENTO = ?1 AND ENTRADA_SAIDA_VEICULO.ID_VEICULO = ?2")
	Veiculo veiculoJaEstacionado(Integer idEstacionamento, Integer idVeiculo);
}
