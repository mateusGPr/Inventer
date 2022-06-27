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

@WebServlet("/centrocusto/cadastrar")
public class CadastrarCentroCustoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CadastrarCentroCustoServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("tituloPagina", "Cadastrar Centro de Custo");

		request.setAttribute("pathView", "/WEB-INF/views/centrocusto/cadastrar.jsp");

		final RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			final CentroCusto centrocusto = new CentroCusto();

			final CentroCustoRepositorio repositorio = new CentroCustoRepositorio();

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

			repositorio.criar(centrocusto);

			PersistenceConfig.closeEntityManager();
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		doGet(request, response);
	}
}