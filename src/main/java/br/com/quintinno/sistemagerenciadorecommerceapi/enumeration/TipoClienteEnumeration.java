package br.com.quintinno.sistemagerenciadorecommerceapi.enumeration;

public enum TipoClienteEnumeration {
	
	PESSOA_FISICA(1, "Pessoa Física", "PF"),
	PESSOA_JURIDICA(2, "Pessoa Jurídica", "PJ");
	
	private Integer codigo;
	private String nome;
	private String sigla;

	private TipoClienteEnumeration(Integer codigo, String nome, String sigla) {
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
	}
	
	public static TipoClienteEnumeration toEnumeration(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		for (TipoClienteEnumeration tipoClienteEnumeration : TipoClienteEnumeration.values()) {
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
