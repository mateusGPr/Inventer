package controlador.centroCusto;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.CentroCusto;
import modelo.repositorio.CentroCustoRepositorio;
import modelo.repositorio.config.PersistenceConfig;

@WebServlet("/centrocusto/excluir")
public class ExcluirCentroCustoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirCentroCustoServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long centrocustoId = 0l;
		CentroCusto centrocusto = null;

		try {
			centrocustoId = Long.parseLong(request.getParameter("id").trim());

			CentroCustoRepositorio repositorio = new CentroCustoRepositorio();

			centrocusto = repositorio.recuperarPorId(centrocustoId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (centrocusto == null)
			centrocusto = new CentroCusto();

		request.setAttribute("centrocusto", centrocusto);

		request.setAttribute("tituloPagina", "Excluir Centro de Custo");

		request.setAttribute("pathView", "/WEB-INF/views/centrocusto/excluir.jsp");

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long patrimonioId = 0l;

		try {
			patrimonioId = Long.parseLong(request.getParameter("id").trim());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (patrimonioId > 0) {
			CentroCustoRepositorio repositorio = new CentroCustoRepositorio();

			CentroCusto centrocusto = repositorio.recuperarPorId(patrimonioId);

			repositorio.excluir(centrocusto);

			PersistenceConfig.closeEntityManager();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/centrocusto");

		rd.forward(request, response);
	}
}