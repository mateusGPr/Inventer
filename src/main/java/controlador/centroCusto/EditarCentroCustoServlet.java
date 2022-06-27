package controlador.centroCusto;

import java.io.IOException;

import controlador.Assign;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.CentroCusto;
import modelo.repositorio.CentroCustoRepositorio;
import modelo.repositorio.config.PersistenceConfig;

@WebServlet("/centrocusto/editar")
public class EditarCentroCustoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarCentroCustoServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long centrocustoId = 0l;
		CentroCusto centrocusto = null;

		try {
			centrocustoId = Long.parseLong(request.getParameter("id").trim());

			final CentroCustoRepositorio repositorio = new CentroCustoRepositorio();

			centrocusto = repositorio.recuperarPorId(centrocustoId);

		} catch (final Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (centrocusto == null) {
			centrocusto = new CentroCusto();
		}

		request.setAttribute("centrocusto", centrocusto);

		request.setAttribute("tituloPagina", "Editar Centro de Custo");

		request.setAttribute("pathView", "/WEB-INF/views/centrocusto/editar.jsp");

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
			final CentroCustoRepositorio repositorio = new CentroCustoRepositorio();

			final CentroCusto centrocusto = repositorio.recuperarPorId(id);

			Assign.Value(str -> centrocusto.setNome(str), request, "nome");
			Assign.Value(str -> centrocusto.setUndAdministrativa(str), request, "undadm");

			/* Class Endereco */
			Assign.Value(str -> centrocusto.setCep(Long.parseLong(str)), request, "cep");
			Assign.Value(str -> centrocusto.setNumero(Integer.parseInt(str)), request, "numero");
			Assign.Value(str -> centrocusto.setLogradouro(str), request, "logradouro");
			Assign.Value(str -> centrocusto.setComplemento(str), request, "complemento");
			Assign.Value(str -> centrocusto.setBairro(str), request, "bairro");
			Assign.Value(str -> centrocusto.setLocalidade(str), request, "localidade");
			Assign.Value(str -> centrocusto.setUf(str), request, "uf");

			repositorio.atualizar(centrocusto);

			PersistenceConfig.closeEntityManager();
		}

		final RequestDispatcher rd = request.getRequestDispatcher("/centrocusto");

		rd.forward(request, response);
	}
}