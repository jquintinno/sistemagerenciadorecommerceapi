package br.com.quintinno.sistemagerenciadorecommerceapi.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.quintinno.sistemagerenciadorecommerceapi.enumeration.TipoSituacaoPagamentoEnumeration;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PAGAMENTO_BOLETO")
public class PagamentoBoletoModel extends PagamentoModel implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	private LocalDateTime dataVencimento;
	
	private LocalDateTime dataPagamento;
	
	public PagamentoBoletoModel() { }

	public PagamentoBoletoModel(TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration, PedidoModel pedidoModel, LocalDateTime dataVencimento, LocalDateTime dataPagamento) {
		super(tipoSituacaoPagamentoEnumeration, pedidoModel);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public LocalDateTime getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDateTime dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDateTime getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDateTime dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
