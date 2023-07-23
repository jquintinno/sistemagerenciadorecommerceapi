package br.com.quintinno.sistemagerenciadorecommerceapi.enumeration;

public enum TipoSituacaoPagamentoEnumeration {
	
	PENDENTE(1, "Pendente", "PEN"),
	QUITADO(2, "Quitado", "QUI"),
	CANCELADO(3, "Cancelado", "CAN");
	
	private Integer codigo;
	private String nome;
	private String sigla;

	private TipoSituacaoPagamentoEnumeration(Integer codigo, String nome, String sigla) {
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
	}
	
	public static TipoSituacaoPagamentoEnumeration toEnumeration(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		for (TipoSituacaoPagamentoEnumeration tipoClienteEnumeration : TipoSituacaoPagamentoEnumeration.values()) {
			if (tipoClienteEnumeration.getCodigo().equals(codigo)) {
				return tipoClienteEnumeration;
			}
		}
		throw new IllegalArgumentException("Tipo do Cliente não encontrado!".concat(codigo.toString()));
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}
	
}
