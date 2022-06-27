package modelo.repositorio;

import javax.persistence.Query;

import modelo.Funcionario;
import modelo.Patrimonio;
import modelo.Setor;
import modelo.repositorio.config.PersistenceConfig;
import modelo.repositorio.config.Repositorio;

public class PatrimonioRepositorio extends Repositorio<Patrimonio, Long> {
	private static final String SETOR_FROM_PATRIMONIO = "SELECT str FROM Setor str JOIN str.patrimonios ptr WHERE ptr.id= :id";
	private static final String FUNCIONARIO_FROM_PATRIMONIO = "SELECT func FROM Funcionario func JOIN func.patrimonios ptr WHERE ptr.id= :id";

	public PatrimonioRepositorio() {
	}

	public Funcionario recuperarFuncionarioById(Long id) {
		Funcionario resultado = null;
		try {
			final Query query = PersistenceConfig.getEntityManager().createQuery(FUNCIONARIO_FROM_PATRIMONIO);
			query.setParameter("id", id);
			resultado = (Funcionario) query.getSingleResult();
		} catch (final Exception e) {
			System.out.println("Erro ao tentar recuperar o Funcionário: " + e.getMessage());
		}

		return resultado;
	}

	public Setor recuperarSetorById(Long id) {
		Setor resultado = null;
		try {
			final Query query = PersistenceConfig.getEntityManager().createQuery(SETOR_FROM_PATRIMONIO);
			query.setParameter("id", id);
			resultado = (Setor) query.getSingleResult();
		} catch (final Exception e) {
			System.out.println("Erro ao tentar recuperar o Setor: " + e.getMessage());
		}

		return resultado;
	}
}
