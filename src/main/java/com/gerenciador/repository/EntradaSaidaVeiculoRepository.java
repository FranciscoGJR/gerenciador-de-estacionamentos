package com.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerenciador.model.EntradaSaidaVeiculo;

public interface EntradaSaidaVeiculoRepository extends JpaRepository<EntradaSaidaVeiculo, Integer>{

	@Query(value = "SELECT esv.id FROM EntradaSaidaVeiculo esv WHERE esv.estacionamento.id = :idEstacionamento AND esv.veiculo.id = :idVeiculo AND esv.status = 'NAO_CONCLUIDO'")
	Integer veiculoJaEstacionado(Integer idEstacionamento, Integer idVeiculo);
}
