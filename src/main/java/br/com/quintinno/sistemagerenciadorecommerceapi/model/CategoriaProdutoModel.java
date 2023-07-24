package br.com.quintinno.sistemagerenciadorecommerceapi.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CATEGORIA_PRODUTO")
public class CategoriaProdutoModel implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "NOME", unique = true)
	private String nome;
	
	@JsonIgnore
	@JsonManagedReference // Recuperar as categorias com todos os seus produtos
	@ManyToMany(mappedBy = "categoriaProdutoModelList")
	Set<ProdutoModel> produtoModelList = new HashSet<>();
	
	public CategoriaProdutoModel() { }

	public CategoriaProdutoModel(String nome) {
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<ProdutoModel> getProdutoModelList() {
		return produtoModelList;
	}

	public void setProdutoModelList(Set<ProdutoModel> produtoModelList) {
		this.produtoModelList = produtoModelList;
	}

}
