package controlador.funcionario;

import java.io.IOException;

import controlador.Assign;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Funcionario;
import modelo.repositorio.FuncionarioRepositorio;
import modelo.repositorio.config.PersistenceConfig;

@WebServlet("/funcionario/editar")
public class EditarFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarFuncionarioServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long funcionarioId = 0l;
		Funcionario funcionario = null;

		try {
			funcionarioId = Long.parseLong(request.getParameter("id").trim());

			final FuncionarioRepositorio repositorio = new FuncionarioRepositorio();

			funcionario = repositorio.recuperarPorId(funcionarioId);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (funcionario == null) {
			funcionario = new Funcionario();
		}

		request.setAttribute("funcionario", funcionario);

		request.setAttribute("tituloPagina", "Editar Funcionário");

		request.setAttribute("pathView", "/WEB-INF/views/funcionario/editar.jsp");

		final RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = 0l;

		try {
			id = Long.parseLong(request.getParameter("id").trim());
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (id > 0) {
			final FuncionarioRepositorio repositorio = new FuncionarioRepositorio();

			final Funcionario funcionario = repositorio.recuperarPorId(id);

			Assign.Value(str -> funcionario.setNome(str), request, "nome");
			Assign.Value(str -> funcionario.setCpf(str), request, "cpf");
			Assign.Value(str -> funcionario.setProntuario(Long.parseLong(str)), request, "prontuario");
			Assign.Value(str -> funcionario.setCargo(str), request, "cargo");

			repositorio.atualizar(funcionario);

			PersistenceConfig.closeEntityManager();
		}

		final RequestDispatcher rd = request.getRequestDispatcher("/funcionario");

		rd.forward(request, response);
	}
}