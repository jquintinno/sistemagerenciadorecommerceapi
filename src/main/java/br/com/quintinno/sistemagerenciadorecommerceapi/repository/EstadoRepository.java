package br.com.quintinno.sistemagerenciadorecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.quintinno.sistemagerenciadorecommerceapi.model.EstadoModel;

public interface EstadoRepository extends JpaRepository<EstadoModel, Long> { }
