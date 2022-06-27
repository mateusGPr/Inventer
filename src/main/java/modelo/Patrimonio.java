package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patrimonio {
	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private String plaqueta;
	private String modelo;
	private String estado;
	private String situacao;
	private String numeroSerie;
	private Float valor;
	private String marca;

	public String getEstado() {
		return estado;
	}

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getNome() {
		return nome;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public String getPlaqueta() {
		return plaqueta;
	}

	public String getSituacao() {
		return situacao;
	}

	public Float getValor() {
		return valor;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public void setPlaqueta(String plaqueta) {
		this.plaqueta = plaqueta;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
}
