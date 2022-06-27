package controlador.patrimonio;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Patrimonio;
import modelo.repositorio.PatrimonioRepositorio;
import modelo.repositorio.config.PersistenceConfig;

@WebServlet({ "/patrimonio/listar", "/patrimonio/todas", "/patrimonio" })
public class ListarPatrimonioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarPatrimonioServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final PatrimonioRepositorio repositorio = new PatrimonioRepositorio();

		final Collection<Patrimonio> patrimonios = repositorio.recuperar();

		PersistenceConfig.closeEntityManager();

		request.setAttribute("patrimonios", patrimonios);

		request.setAttribute("tituloPagina", "Patrimônios");

		request.setAttribute("pathView", "/WEB-INF/views/patrimonio/listar.jsp");

		final RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
