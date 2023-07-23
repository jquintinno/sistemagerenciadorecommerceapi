package br.com.quintinno.sistemagerenciadorecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.quintinno.sistemagerenciadorecommerceapi.model.PedidoModel;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> { }
