package controlador.funcionario;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Funcionario;
import modelo.repositorio.FuncionarioRepositorio;
import modelo.repositorio.config.PersistenceConfig;

@WebServlet({ "/funcionario/listar", "/funcionario/todas", "/funcionario" })
public class ListarFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarFuncionarioServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final FuncionarioRepositorio repositorio = new FuncionarioRepositorio();

		final Collection<Funcionario> funcionarios = repositorio.recuperar();

		PersistenceConfig.closeEntityManager();

		request.setAttribute("funcionarios", funcionarios);

		request.setAttribute("tituloPagina", "Funcionários");

		request.setAttribute("pathView", "/WEB-INF/views/funcionario/listar.jsp");

		final RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}