package modelo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Endereco {
	@Column(nullable = false)
	protected long cep;

	@Column(nullable = false)
	protected Integer numero;

	@Column(nullable = false)
	protected String logradouro;

	@Column(nullable = true)
	protected String complemento;

	@Column(nullable = false)
	protected String bairro;

	@Column(nullable = false)
	protected String localidade;

	@Column(nullable = false)
	protected String uf;

	public String getBairro() {
		return bairro;
	}

	public long getCep() {
		return cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getUf() {
		return uf;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCep(long cep) {
		this.cep = cep;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
