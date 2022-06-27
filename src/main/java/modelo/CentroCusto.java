package modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "centro_custo")
public class CentroCusto extends Endereco {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String undAdministrativa;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private Collection<Setor> setores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUndAdministrativa() {
		return undAdministrativa;
	}

	public void setUndAdministrativa(String undAdministrativa) {
		this.undAdministrativa = undAdministrativa;
	}

	public Collection<Setor> getSetores() {
		return setores;
	}

	public void setSetores(Collection<Setor> setores) {
		this.setores = setores;
	}
}
