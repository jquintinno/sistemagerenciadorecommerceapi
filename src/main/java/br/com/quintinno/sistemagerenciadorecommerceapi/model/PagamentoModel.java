package br.com.quintinno.sistemagerenciadorecommerceapi.model;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.quintinno.sistemagerenciadorecommerceapi.enumeration.TipoSituacaoPagamentoEnumeration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PAGAMENTO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PagamentoModel implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CODIGO")
	private Long codigo;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "ID_PEDIDO")
	@MapsId // Garantir que o ID do Pedido sera igual ao do Pagamento
	private PedidoModel pedidoModel;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_SITUACAO_PAGAMENTO")
	private TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration;
	
	public PagamentoModel() { }

	public PagamentoModel(TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration, PedidoModel pedidoModel) {
		this.tipoSituacaoPagamentoEnumeration = tipoSituacaoPagamentoEnumeration;
		this.pedidoModel = pedidoModel;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TipoSituacaoPagamentoEnumeration getTipoEstadoPagamentoEnumeration() {
		return tipoSituacaoPagamentoEnumeration;
	}

	public void setTipoEstadoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration) {
		this.tipoSituacaoPagamentoEnumeration = tipoSituacaoPagamentoEnumeration;
	}

	public PedidoModel getPedidoModel() {
		return pedidoModel;
	}

	public void setPedidoModel(PedidoModel pedidoModel) {
		this.pedidoModel = pedidoModel;
	}

}
