package br.com.quintinno.sistemagerenciadorecommerceapi.model;

import java.io.Serial;
import java.io.Serializable;

import br.com.quintinno.sistemagerenciadorecommerceapi.enumeration.TipoSituacaoPagamentoEnumeration;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PAGAMENTO_CARTAO")
public class PagamentoCartaoModel extends PagamentoModel implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	private Integer quantidadeParcela;
	
	public PagamentoCartaoModel() { }

	public PagamentoCartaoModel(TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration, PedidoModel pedidoModel, Integer quantidadeParcela) {
		super(tipoSituacaoPagamentoEnumeration, pedidoModel);
		this.quantidadeParcela = quantidadeParcela;
	}

	public Integer getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(Integer quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

}
