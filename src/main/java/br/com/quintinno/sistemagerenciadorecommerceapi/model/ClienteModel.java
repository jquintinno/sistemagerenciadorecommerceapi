package br.com.quintinno.sistemagerenciadorecommerceapi.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.quintinno.sistemagerenciadorecommerceapi.enumeration.TipoClienteEnumeration;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "CPF_CNPJ")
	private String cpfCnpj;
	
	@Column(name = "TIPO_CLIENTE")
	private Integer codigoTipoClienteEnumeration;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "clienteModel", cascade = CascadeType.ALL)
	private Set<EnderecoModel> enderecoModelList = new HashSet<>();
	
	@ElementCollection
	@CollectionTable(name = "TB_TELEFONE", joinColumns = @JoinColumn(name="ID_CLIENTE"))
	@Column(name = "NUMERO_TELEFONE")
	private Set<String> telefoneList = new HashSet<>();
	
	public ClienteModel() { }

	public ClienteModel(String nome, String email, String cpfCnpj, Integer codigoTipoClienteEnumeration) {
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.codigoTipoClienteEnumeration = codigoTipoClienteEnumeration;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public TipoClienteEnumeration getCodigoTipoClienteEnumeration() {
		return TipoClienteEnumeration.toEnumeration(codigoTipoClienteEnumeration);
	}

	public void setCodigoTipoClienteEnumeration(TipoClienteEnumeration codigoTipoClienteEnumeration) {
		this.codigoTipoClienteEnumeration = codigoTipoClienteEnumeration.getCodigo();
	}

	public Set<EnderecoModel> getEnderecoModelList() {
		return enderecoModelList;
	}

	public void setEnderecoModelList(Set<EnderecoModel> enderecoModelList) {
		this.enderecoModelList = enderecoModelList;
	}

	public Set<String> getTelefoneList() {
		return telefoneList;
	}

	public void setTelefoneList(Set<String> telefoneList) {
		this.telefoneList = telefoneList;
	}

}
