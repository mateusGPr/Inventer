package modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Setor extends Endereco {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private Long codigo;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Collection<Patrimonio> patrimonios;

	public Long getCodigo() {
		return codigo;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Collection<Patrimonio> getPatrimonios() {
		return patrimonios;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPatrimonios(Collection<Patrimonio> patrimonios) {
		this.patrimonios = patrimonios;
	}
}
