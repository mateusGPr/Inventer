package controlador.funcionario;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Funcionario;
import modelo.repositorio.FuncionarioRepositorio;
import modelo.repositorio.config.PersistenceConfig;

@WebServlet("/funcionario/excluir")
public class ExcluirFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirFuncionarioServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long funcionarioId = 0l;
		Funcionario funcionario = null;

		try {
			funcionarioId = Long.parseLong(request.getParameter("id").trim());

			FuncionarioRepositorio repositorio = new FuncionarioRepositorio();

			funcionario = repositorio.recuperarPorId(funcionarioId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (funcionario == null)
			funcionario = new Funcionario();

		request.setAttribute("funcionario", funcionario);

		request.setAttribute("tituloPagina", "Excluir Funcionário");

		request.setAttribute("pathView", "/WEB-INF/views/funcionario/excluir.jsp");

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
			FuncionarioRepositorio repositorio = new FuncionarioRepositorio();

			Funcionario funcionario = repositorio.recuperarPorId(patrimonioId);

			repositorio.excluir(funcionario);

			PersistenceConfig.closeEntityManager();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/funcionario");

		rd.forward(request, response);
	}
}