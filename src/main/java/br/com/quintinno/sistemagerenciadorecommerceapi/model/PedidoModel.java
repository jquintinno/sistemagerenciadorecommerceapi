package br.com.quintinno.sistemagerenciadorecommerceapi.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PEDIDO")
public class PedidoModel implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@JsonFormat(pattern = "dd/mm/yyyy HH:mm:ss")
	@Column(name = "DATA_HORA")
	private LocalDateTime dataHora;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "pedidoModel", cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PAGAMENTO")
	private PagamentoModel pagamentoModel;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private ClienteModel clienteModel;
	
	@ManyToOne
	@JoinColumn(name = "ID_ENDENRECO")
	private EnderecoModel enderecoEntrega;
	
	@JsonIgnore
	@OneToMany(mappedBy = "codigo.pedidoModel")
	private Set<ItemPedidoModel> itemPedidoModelList = new HashSet<>();
	
	public PedidoModel() { }

	public PedidoModel(LocalDateTime dataHora, ClienteModel clienteModel, EnderecoModel enderecoEntrega) {
		this.dataHora = dataHora;
		this.clienteModel = clienteModel;
		this.enderecoEntrega = enderecoEntrega;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public PagamentoModel getPagamentoModel() {
		return pagamentoModel;
	}

	public void setPagamentoModel(PagamentoModel pagamentoModel) {
		this.pagamentoModel = pagamentoModel;
	}

	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

	public EnderecoModel getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(EnderecoModel enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Set<ItemPedidoModel> getItemPedidoModelList() {
		return itemPedidoModelList;
	}

	public void setItemPedidoModelList(Set<ItemPedidoModel> itemPedidoModelList) {
		this.itemPedidoModelList = itemPedidoModelList;
	}

}
