package br.com.quintinno.sistemagerenciadorecommerceapi.dto;

public class ExceptionResponseDTO {
	
	private String situacaoErro;
	
	private String mensagemErro;
	
	private String dataHoraErro;
	
	public ExceptionResponseDTO() { }

	public ExceptionResponseDTO(String codigoSituacaoErro, String mensagemErro, String dataHoraErro) {
		this.situacaoErro = codigoSituacaoErro;
		this.mensagemErro = mensagemErro;
		this.dataHoraErro = dataHoraErro;
	}

	public String getSituacaoErro() {
		return situacaoErro;
	}

	public void setCodigoSituacaoErro(String situacaoErro) {
		this.situacaoErro = situacaoErro;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public String getDataHoraErro() {
		return dataHoraErro;
	}

	public void setDataHoraErro(String dataHoraErro) {
		this.dataHoraErro = dataHoraErro;
	}

}
