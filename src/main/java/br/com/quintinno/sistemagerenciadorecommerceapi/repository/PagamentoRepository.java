package br.com.quintinno.sistemagerenciadorecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.quintinno.sistemagerenciadorecommerceapi.model.PagamentoModel;

public interface PagamentoRepository extends JpaRepository<PagamentoModel, Long> { }
