package br.com.quintinno.sistemagerenciadorecommerceapi.model;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ITEM_PEDIDO")
public class ItemPedidoModel implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPK codigo = new ItemPedidoPK();
	
	@Column(name = "VALOR_DESCONTO")
	private BigDecimal valorDesconto;
	
	@Column(name = "QUANTIDADE")
	private Integer quantidade;
	
	@Column(name = "PRECO")
	private BigDecimal preco;
	
	public ItemPedidoModel() { }

	public ItemPedidoModel(PedidoModel pedidoModel, ProdutoModel produtoModel, BigDecimal valorDesconto, Integer quantidade, BigDecimal preco) {
		this.codigo.setPedidoModel(pedidoModel);
		this.codigo.setProdutoModel(produtoModel);
		this.valorDesconto = valorDesconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	@JsonBackReference
	// --
	public PedidoModel getPedidoModel() {
		return this.codigo.getPedidoModel();
	}
	
	// --
	public ProdutoModel getProdutoModel() {
		return this.codigo.getProdutoModel();
	}

	public ItemPedidoPK getCodigo() {
		return codigo;
	}

	public void setCodigo(ItemPedidoPK codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
