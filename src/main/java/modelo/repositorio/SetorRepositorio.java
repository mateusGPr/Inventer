package modelo.repositorio;

import javax.persistence.Query;

import modelo.CentroCusto;
import modelo.Setor;
import modelo.repositorio.config.PersistenceConfig;
import modelo.repositorio.config.Repositorio;

public class SetorRepositorio extends Repositorio<Setor, Long> {
	private static final String CENTROCUSTO_FROM_SETOR = """
			SELECT ctc
			FROM CentroCusto ctc
			JOIN ctc.setores str
			WHERE str.id= :id
			""";

	public SetorRepositorio() {
	}

	public CentroCusto recuperarCentroCustoById(Long id) {
		CentroCusto resultado = null;
		try {
			final Query query = PersistenceConfig.getEntityManager().createQuery(CENTROCUSTO_FROM_SETOR);
			query.setParameter("id", id);
			resultado = (CentroCusto) query.getSingleResult();
		} catch (final Exception e) {
			System.out.println("Erro ao tentar recuperar o Centro de Custo: " + e.getMessage());
		}

		return resultado;
	}
}