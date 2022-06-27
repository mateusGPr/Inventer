package modelo.repositorio.config;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.persistence.EntityTransaction;

public abstract class Repositorio<T, KeyType> {
	private final Class<T> ClassType;

	@SuppressWarnings("unchecked")
	public Repositorio() {
		final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		ClassType = (Class<T>) type.getActualTypeArguments()[0];
	}

	public boolean atualizar(T entidade) {
		boolean resultado = true;

		final EntityTransaction transacao = PersistenceConfig.getEntityManager().getTransaction();

		try {
			transacao.begin();
			PersistenceConfig.getEntityManager().merge(entidade);
			transacao.commit();
		} catch (final Exception e) {
			System.out.println("Erro ao tentar atualizar: " + e.getMessage());
			transacao.rollback();
			resultado = false;
		}

		return resultado;
	}

	public boolean criar(T entidade) {
		boolean resultado = true;

		final EntityTransaction transacao = PersistenceConfig.getEntityManager().getTransaction();

		try {
			transacao.begin();
			PersistenceConfig.getEntityManager().persist(entidade);
			transacao.commit();
		} catch (final Exception e) {
			System.out.println("Erro ao tentar persistir: " + e.getMessage());
			resultado = false;
			transacao.rollback();
		}

		return resultado;
	}

	public boolean excluir(T entidade) {
		boolean resultado = true;

		final EntityTransaction transacao = PersistenceConfig.getEntityManager().getTransaction();

		try {
			transacao.begin();
			PersistenceConfig.getEntityManager().remove(entidade);
			transacao.commit();
		} catch (final Exception e) {
			System.out.println("Erro ao tentar excluir: " + e.getMessage());
			transacao.rollback();
			resultado = false;
		}

		return resultado;
	}

	@SuppressWarnings("unchecked")
	public Collection<T> recuperar() {
		Collection<T> resultado = null;

		try {
			resultado = PersistenceConfig.getEntityManager().createQuery("FROM " + ClassType.getName()).getResultList();
		} catch (final Exception e) {
			System.out.println("Erro ao tentar recuperar: " + e.getMessage());
		}

		return resultado;
	}

	public T recuperarPorId(KeyType id) {
		T resultado = null;

		try {
			resultado = PersistenceConfig.getEntityManager().find(ClassType, id);
		} catch (final Exception e) {
			System.out.println("Erro ao tentar recuperar: " + e.getMessage());
		}

		return resultado;
	}
}
