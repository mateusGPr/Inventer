package modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Funcionario {
	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private String cpf;
	private Long prontuario;
	private String cargo;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Collection<Patrimonio> patrimonios;

	public String getCargo() {
		return cargo;
	}

	public String getCpf() {
		return cpf;
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

	public Long getProntuario() {
		return prontuario;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public void setProntuario(Long prontuario) {
		this.prontuario = prontuario;
	}
}
