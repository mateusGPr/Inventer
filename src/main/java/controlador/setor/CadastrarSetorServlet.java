package controlador.setor;

import java.io.IOException;
import java.util.Collection;

import controlador.Assign;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.CentroCusto;
import modelo.Setor;
import modelo.repositorio.CentroCustoRepositorio;
import modelo.repositorio.SetorRepositorio;
import modelo.repositorio.config.PersistenceConfig;

@WebServlet("/setor/cadastrar")
public class CadastrarSetorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarSetorServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final CentroCustoRepositorio repositorioCC = new CentroCustoRepositorio();
		final Collection<CentroCusto> centrocusto = repositorioCC.recuperar();

		PersistenceConfig.closeEntityManager();

		request.setAttribute("centrocusto", centrocusto);
		request.setAttribute("tituloPagina", "Cadastrar Setor");

		request.setAttribute("pathView", "/WEB-INF/views/setor/cadastrar.jsp");

		final RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			final CentroCustoRepositorio repositorioCC = new CentroCustoRepositorio();
			final SetorRepositorio repositorio = new SetorRepositorio();

			final Long id = Long.parseLong(request.getParameter("ccId").trim());

			if (id < 1) {
				throw new Exception("ccId não definido.");
			}

			final CentroCusto centrocusto = repositorioCC.recuperarPorId(id);

			if (centrocusto == null) {
				throw new Exception("Não foi possível localizar o Centro de Custo.");
			}

			final Setor setor = PersistSetor(repositorio, request);

			centrocusto.getSetores().add(setor);

			repositorioCC.atualizar(centrocusto);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			PersistenceConfig.closeEntityManager();
		}
		doGet(request, response);
	}

	protected Setor PersistSetor(SetorRepositorio sr, HttpServletRequest request) {
		final Setor setor = new Setor();

		Assign.Value(str -> setor.setNome(str), request, "nome");
		Assign.Value(str -> setor.setCodigo(Long.parseLong(str)), request, "codigo");

		/* Class Endereco */
		Assign.Value(str -> setor.setCep(Long.parseLong(str)), request, "cep");
		Assign.Value(str -> setor.setNumero(Integer.parseInt(str)), request, "numero");
		Assign.Value(str -> setor.setLogradouro(str), request, "logradouro");
		Assign.Value(str -> setor.setComplemento(str), request, "complemento");
		Assign.Value(str -> setor.setBairro(str), request, "bairro");
		Assign.Value(str -> setor.setLocalidade(str), request, "localidade");
		Assign.Value(str -> setor.setUf(str), request, "uf");

		sr.criar(setor);
		return setor;
	}
}