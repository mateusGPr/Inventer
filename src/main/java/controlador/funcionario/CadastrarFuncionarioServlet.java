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

@WebServlet("/funcionario/cadastrar")
public class CadastrarFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarFuncionarioServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("tituloPagina", "Cadastrar Funcionário");

		request.setAttribute("pathView", "/WEB-INF/views/funcionario/cadastrar.jsp");

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Funcionario funcionario = new Funcionario();


		FuncionarioRepositorio repositorio = new FuncionarioRepositorio();

		Assign.Value((str) -> funcionario.setNome(str), request, "nome");
		Assign.Value((str) -> funcionario.setCpf(str), request, "cpf");
		Assign.Value((str) -> funcionario.setProntuario(Long.parseLong(str)), request, "prontuario");
		Assign.Value((str) -> funcionario.setCargo(str), request, "cargo");

		repositorio.criar(funcionario);

		PersistenceConfig.closeEntityManager();

		doGet(request, response);
	}
}