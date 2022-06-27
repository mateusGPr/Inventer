package controlador.patrimonio;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Patrimonio;
import modelo.repositorio.FuncionarioRepositorio;
import modelo.repositorio.PatrimonioRepositorio;
import modelo.repositorio.SetorRepositorio;
import modelo.repositorio.config.PersistenceConfig;

@WebServlet("/patrimonio/excluir")
public class ExcluirPatrimonioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirPatrimonioServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long patrimonioId = 0l;
		Patrimonio patrimonio = null;

		try {
			patrimonioId = Long.parseLong(request.getParameter("id").trim());

			final PatrimonioRepositorio repositorio = new PatrimonioRepositorio();

			patrimonio = repositorio.recuperarPorId(patrimonioId);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (patrimonio == null) {
			patrimonio = new Patrimonio();
		}

		request.setAttribute("patrimonio", patrimonio);

		request.setAttribute("tituloPagina", "Excluir Patrimônio");

		request.setAttribute("pathView", "/WEB-INF/views/patrimonio/excluir.jsp");

		final RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long patrimonioId = 0l;

		try {
			patrimonioId = Long.parseLong(request.getParameter("id").trim());
			if (patrimonioId > 0) {
				final PatrimonioRepositorio repositorio = new PatrimonioRepositorio();

				final Patrimonio patrimonio = repositorio.recuperarPorId(patrimonioId);

				final var setor = repositorio.recuperarSetorById(patrimonioId);
				final var funcionario = repositorio.recuperarFuncionarioById(patrimonioId);

				if (setor != null) {
					final SetorRepositorio setorRepo = new SetorRepositorio();

					setor.getPatrimonios().remove(patrimonio);
					setorRepo.atualizar(setor);
					System.out.println("Setor removido...");
				}

				if (funcionario != null) {
					final FuncionarioRepositorio funcRepo = new FuncionarioRepositorio();

					funcionario.getPatrimonios().remove(patrimonio);
					funcRepo.atualizar(funcionario);
					System.out.println("Funcionario removido...");
				}
				repositorio.excluir(patrimonio);
			}
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			PersistenceConfig.closeEntityManager();
		}

		final RequestDispatcher rd = request.getRequestDispatcher("/patrimonio");

		rd.forward(request, response);
	}
}
