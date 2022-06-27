package controlador.patrimonio;

import java.io.IOException;

import controlador.Assign;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Patrimonio;
import modelo.repositorio.PatrimonioRepositorio;
import modelo.repositorio.config.PersistenceConfig;

@WebServlet("/patrimonio/editar")
public class EditarPatrimonioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarPatrimonioServlet() {
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

		request.setAttribute("tituloPagina", "Editar Patrimônio");

		request.setAttribute("pathView", "/WEB-INF/views/patrimonio/editar.jsp");

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
			final PatrimonioRepositorio repositorio = new PatrimonioRepositorio();

			final Patrimonio patrimonio = repositorio.recuperarPorId(id);

			Assign.Value(str -> patrimonio.setNome(str), request, "nome");
			Assign.Value(str -> patrimonio.setPlaqueta(str), request, "plaqueta");
			Assign.Value(str -> patrimonio.setModelo(str), request, "modelo");
			Assign.Value(str -> patrimonio.setEstado(str), request, "estado");
			Assign.Value(str -> patrimonio.setSituacao(str), request, "situacao");
			Assign.Value(str -> patrimonio.setNumeroSerie(str), request, "numeroSerie");
			Assign.Value(str -> patrimonio.setValor(Float.parseFloat(str)), request, "valor");
			Assign.Value(str -> patrimonio.setMarca(str), request, "marca");

			repositorio.atualizar(patrimonio);

			PersistenceConfig.closeEntityManager();
		}

		final RequestDispatcher rd = request.getRequestDispatcher("/patrimonio");

		rd.forward(request, response);
	}
}
