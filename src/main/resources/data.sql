INSERT INTO Estabelecimento (estabelecimento_identificador, nome, cnpj, endereco, telefone, quantidade_vagas_motos, quantidade_vagas_carros)
VALUES
  (1, 'Estabelecimento 1', '12345678901234', 'Rua A, 123', '123456789', 50, 100),
  (2, 'Estabelecimento 2', '98765432109876', 'Avenida B, 456', '987654321', 30, 80),
  (3, 'Estabelecimento 3', '45678901234567', 'Praça C, 789', '345678901', 20, 50);

INSERT INTO Veiculo (veiculo_identificador, marca_do_veiculo, cor_do_veiculo, placa_do_veiculo, tipo_do_veiculo, estabelecimento_identificador)
VALUES
  (1, 'Marca 1', 'Azul', 'ABC123', 'CARRO', 1),
  (2, 'Marca 2', 'Vermelho', 'XYZ987', 'MOTO', 1),
  (3, 'Marca 3', 'Preto', 'DEF456', 'CARRO', 2),
  (4, 'Marca 4', 'Branco', 'HIJ789', 'MOTO', 2),
  (5, 'Marca 5', 'Verde', 'JKL012', 'CARRO', 3),
  (6, 'Marca 6', 'Amarelo', 'MNO345', 'MOTO', 3);
