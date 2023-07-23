package br.com.quintinno.sistemagerenciadorecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.quintinno.sistemagerenciadorecommerceapi.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> { }
