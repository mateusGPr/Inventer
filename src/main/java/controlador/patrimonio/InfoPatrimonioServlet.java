package controlador.patrimonio;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Funcionario;
import modelo.Patrimonio;
import modelo.Setor;
import modelo.repositorio.PatrimonioRepositorio;

@WebServlet("/patrimonio/info")
public class InfoPatrimonioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InfoPatrimonioServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long patrimonioId = 0l;
		Patrimonio patrimonio = null;
		Funcionario funcionario = null;
		Setor setor = null;

		try {
			patrimonioId = Long.parseLong(request.getParameter("id").trim());

			final PatrimonioRepositorio repositorio = new PatrimonioRepositorio();

			patrimonio = repositorio.recuperarPorId(patrimonioId);
			setor = repositorio.recuperarSetorById(patrimonioId);
			funcionario = repositorio.recuperarFuncionarioById(patrimonioId);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (patrimonio == null) {
			patrimonio = new Patrimonio();
		}

		if (funcionario == null) {
			funcionario = new Funcionario();
		}

		if (setor == null) {
			setor = new Setor();
		}

		request.setAttribute("patrimonio", patrimonio);
		request.setAttribute("setor", setor);
		request.setAttribute("funcionario", funcionario);

		request.setAttribute("tituloPagina", "Ver Patrimônio");

		request.setAttribute("pathView", "/WEB-INF/views/patrimonio/info.jsp");

		final RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
