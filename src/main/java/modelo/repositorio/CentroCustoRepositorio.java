package modelo.repositorio;

import modelo.CentroCusto;
import modelo.repositorio.config.Repositorio;

public class CentroCustoRepositorio extends Repositorio<CentroCusto, Long> {
//	private static final String FROM_EMPRESA_JOIN_CENTRO_CUSTO = "SELECT emp FROM Empresa emp JOIN emp.centroCustos ctc WHERE ctc.id= :id";

	public CentroCustoRepositorio() {
		super();
	}
//
//	public Empresa recuperarEmpresaById(Long id) {
//		Empresa resultado = null;
//		try {
//			Query query = PersistenceConfig.getEntityManager().createQuery(FROM_EMPRESA_JOIN_CENTRO_CUSTO);
//			query.setParameter("id", id);
//			resultado = (Empresa)query.getSingleResult();
//		} catch (Exception e) {
//			System.out.println("Erro ao tentar recuperar as pessoas físicas cadastradas! " + e.getMessage());
//		}
//
//		return resultado;
//	}
}
