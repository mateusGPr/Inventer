package controlador.centroCusto;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.CentroCusto;
import modelo.repositorio.CentroCustoRepositorio;
import modelo.repositorio.config.PersistenceConfig;

@WebServlet({ "/centrocusto/listar", "/centrocusto/todas", "/centrocusto" })
public class ListarCentroCustoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarCentroCustoServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		CentroCustoRepositorio repositorio = new CentroCustoRepositorio();

		Collection<CentroCusto> centrocustos =
				repositorio.recuperar();

		PersistenceConfig.closeEntityManager();

		request.setAttribute("centrocusto", centrocustos);

		request.setAttribute("tituloPagina",
				"Centro de Custos");

		request.setAttribute("pathView",
				"/WEB-INF/views/centrocusto/listar.jsp");

		RequestDispatcher rd =
				request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}