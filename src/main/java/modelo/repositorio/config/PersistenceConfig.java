package modelo.repositorio.config;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceConfig {
	private static EntityManager entityManager;

	public static void closeEntityManager() {
		if (entityManager != null) {
			try {
				entityManager.close();
				entityManager = null;
				System.out.println("Gerenciador de Entidades fechado com sucesso!");
			} catch (final Exception e) {
				System.out.println("Erro ao tentar fechar o gerenciador de entidades. " + e.getMessage());
			}
		}
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			try {
				final Map<String, String> env = System.getenv();
				final Map<String, Object> configOverrides = new HashMap<>();

				for (final String envName : env.keySet()) {
					if (envName.contains("DATABASE_URL")) {
						final URI uri = new URI(env.get(envName));

						final String url = "jdbc:postgresql://" + uri.getHost() + ":" + uri.getPort() + uri.getPath();
						final String user = uri.getUserInfo().split(":")[0];
						final String password = uri.getUserInfo().split(":")[1];

						System.err.println("Override: javax.persistence.jdbc.url = " + url);
						System.err.println("Override: javax.persistence.jdbc.user = " + user);
						System.err.println("Override: javax.persistence.jdbc.password = " + password + url);

						configOverrides.put("javax.persistence.jdbc.url", url);
						configOverrides.put("javax.persistence.jdbc.user", user);
						configOverrides.put("javax.persistence.jdbc.password", password);
					}
				}

				final EntityManagerFactory factory = Persistence.createEntityManagerFactory("inventarioHBDB",
						configOverrides);

				entityManager = factory.createEntityManager();
				System.out.println("Gerenciador de entidades instanciado com sucesso.");
			} catch (final Exception e) {
				System.out.println("Erro ao tentar instanciar um gerenciador de entidades. " + e.getMessage());
			}
		}

		return entityManager;
	}
}
