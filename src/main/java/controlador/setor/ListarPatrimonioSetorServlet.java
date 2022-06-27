package controlador.setor;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Setor;
import modelo.repositorio.SetorRepositorio;
import modelo.repositorio.config.PersistenceConfig;

@WebServlet({ "/setor/patrimonio" })
public class ListarPatrimonioSetorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarPatrimonioSetorServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		SetorRepositorio repositorio = new SetorRepositorio();

		Collection<Setor> setores =
				repositorio.recuperar();

		PersistenceConfig.closeEntityManager();

		request.setAttribute("setores", setores);

		request.setAttribute("tituloPagina",
				"Setores");

		request.setAttribute("pathView",
				"/WEB-INF/views/setor/patrimonio.jsp");

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