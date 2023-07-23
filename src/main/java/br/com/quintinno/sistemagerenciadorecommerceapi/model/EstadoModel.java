package br.com.quintinno.sistemagerenciadorecommerceapi.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ESTADO")
public class EstadoModel implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "SIGLA")
	private String sigla;
	
	@OneToMany(mappedBy = "estadoModel", cascade = CascadeType.ALL)
	Set<CidadeModel> cidadeModelList = new HashSet<>();
	
	public EstadoModel() { }

	public EstadoModel(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Set<CidadeModel> getCidadeModelList() {
		return cidadeModelList;
	}

	public void setCidadeModelList(Set<CidadeModel> cidadeModelList) {
		this.cidadeModelList = cidadeModelList;
	}

}
