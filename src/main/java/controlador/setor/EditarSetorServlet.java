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

@WebServlet("/setor/editar")
public class EditarSetorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarSetorServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Collection<CentroCusto> centrocusto = null;
		Long setorId = 0l;
		Setor setor = null;
		CentroCusto currentCC = null;

		try {
			setorId = Long.parseLong(request.getParameter("id").trim());

			final SetorRepositorio repositorio = new SetorRepositorio();

			final CentroCustoRepositorio repositorioCC = new CentroCustoRepositorio();
			centrocusto = repositorioCC.recuperar();

			PersistenceConfig.closeEntityManager();

			currentCC = repositorio.recuperarCentroCustoById(setorId);
			setor = repositorio.recuperarPorId(setorId);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (setor == null) {
			setor = new Setor();
		}

		request.setAttribute("centrocusto", centrocusto);
		request.setAttribute("currentcc", currentCC);
		request.setAttribute("setor", setor);

		request.setAttribute("tituloPagina", "Editar Setor");

		request.setAttribute("pathView", "/WEB-INF/views/setor/editar.jsp");

		final RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			final CentroCustoRepositorio repositorioCC = new CentroCustoRepositorio();
			final SetorRepositorio repositorio = new SetorRepositorio();

			final Long ccId = Long.parseLong(request.getParameter("ccId").trim());
			final Long id = Long.parseLong(request.getParameter("id").trim());

			if (ccId < 1) {
				throw new Exception("ccId não definido.");
			}

			final CentroCusto centrocusto = repositorioCC.recuperarPorId(ccId);

			if (centrocusto == null) {
				throw new Exception("Não foi possível localizar o Centro de Custo.");
			}

			final Setor setor = PersistSetor(repositorio, id, request);
			final CentroCusto currentCC = repositorio.recuperarCentroCustoById(id);

			if (currentCC != centrocusto) {
				if (currentCC != null) {
					currentCC.getSetores().remove(setor);
					repositorioCC.atualizar(currentCC);
				}
				centrocusto.getSetores().add(setor);
				repositorioCC.atualizar(centrocusto);
			}
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			PersistenceConfig.closeEntityManager();
		}

		final RequestDispatcher rd = request.getRequestDispatcher("/setor");

		rd.forward(request, response);
	}

	protected Setor PersistSetor(SetorRepositorio repositorio, Long id, HttpServletRequest request) {
		final Setor setor = repositorio.recuperarPorId(id);

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

		repositorio.atualizar(setor);
		return setor;
	}
}