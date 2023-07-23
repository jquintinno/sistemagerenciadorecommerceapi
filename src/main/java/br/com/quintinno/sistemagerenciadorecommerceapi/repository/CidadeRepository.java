package br.com.quintinno.sistemagerenciadorecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.quintinno.sistemagerenciadorecommerceapi.model.CidadeModel;

public interface CidadeRepository extends JpaRepository<CidadeModel, Long> { }
