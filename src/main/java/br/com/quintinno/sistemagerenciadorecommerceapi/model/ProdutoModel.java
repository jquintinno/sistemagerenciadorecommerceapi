package br.com.quintinno.sistemagerenciadorecommerceapi.model;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "PRECO")
	private BigDecimal preco;
	
	@ManyToMany
	@JoinTable(name = "TB_PRODUTO_CATEGORIA_PRODUTO", 
		joinColumns = @JoinColumn(name = "ID_PRODUTO"), 
		inverseJoinColumns = @JoinColumn(name = "ID_CATEGORIA_PRODUTO")
	)
	Set<CategoriaProdutoModel> categoriaProdutoModelList = new HashSet<>();
	
	public ProdutoModel() { }

	public ProdutoModel(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Set<CategoriaProdutoModel> getCategoriaProdutoModelList() {
		return categoriaProdutoModelList;
	}

	public void setCategoriaProdutoModelList(Set<CategoriaProdutoModel> categoriaProdutoModelList) {
		this.categoriaProdutoModelList = categoriaProdutoModelList;
	}

}
