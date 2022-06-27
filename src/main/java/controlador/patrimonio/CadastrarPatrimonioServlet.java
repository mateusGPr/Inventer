package controlador.patrimonio;

import java.io.IOException;
import java.util.Collection;

import controlador.Assign;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Funcionario;
import modelo.Patrimonio;
import modelo.Setor;
import modelo.repositorio.FuncionarioRepositorio;
import modelo.repositorio.PatrimonioRepositorio;
import modelo.repositorio.SetorRepositorio;
import modelo.repositorio.config.PersistenceConfig;

@WebServlet("/patrimonio/cadastrar")
public class CadastrarPatrimonioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarPatrimonioServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final SetorRepositorio repositorioST = new SetorRepositorio();
		final Collection<Setor> setores = repositorioST.recuperar();

		final FuncionarioRepositorio repositorioFN = new FuncionarioRepositorio();
		final Collection<Funcionario> funcionarios = repositorioFN.recuperar();

		PersistenceConfig.closeEntityManager();

		request.setAttribute("funcionarios", funcionarios);
		request.setAttribute("setores", setores);

		request.setAttribute("tituloPagina", "Incorporar Patrimônio");

		request.setAttribute("pathView", "/WEB-INF/views/patrimonio/cadastrar.jsp");

		final RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			final SetorRepositorio setorRepo = new SetorRepositorio();
			final FuncionarioRepositorio funcRepo = new FuncionarioRepositorio();
			final PatrimonioRepositorio repositorio = new PatrimonioRepositorio();

			final Long setorId = Long.parseLong(request.getParameter("setorId").trim());
			final Long funcId = Long.parseLong(request.getParameter("funcId").trim());

			if (setorId < 1 || funcId < 1) {
				throw new Exception("setorId ou funcId não definido.");
			}

			final Setor setor = setorRepo.recuperarPorId(setorId);
			final Funcionario funcionario = funcRepo.recuperarPorId(funcId);

			if (setor == null || funcionario == null) {
				throw new Exception("Não foi possível localizar o Setor ou o Funcionário.");
			}

			final Patrimonio patrimonio = PersistPatrimonio(repositorio, request);
			
			setor.getPatrimonios().add(patrimonio);
			funcionario.getPatrimonios().add(patrimonio);
			
			funcRepo.atualizar(funcionario);
			setorRepo.atualizar(setor);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			PersistenceConfig.closeEntityManager();
		}
		doGet(request, response);
	}

	protected Patrimonio PersistPatrimonio(PatrimonioRepositorio repositorio, HttpServletRequest request) {
		final Patrimonio patrimonio = new Patrimonio();

		Assign.Value(str -> patrimonio.setNome(str), request, "nome");
		Assign.Value(str -> patrimonio.setPlaqueta(str), request, "plaqueta");
		Assign.Value(str -> patrimonio.setModelo(str), request, "modelo");
		Assign.Value(str -> patrimonio.setEstado(str), request, "estado");
		Assign.Value(str -> patrimonio.setSituacao(str), request, "situacao");
		Assign.Value(str -> patrimonio.setNumeroSerie(str), request, "numeroSerie");
		Assign.Value(str -> patrimonio.setValor(Float.parseFloat(str)), request, "valor");
		Assign.Value(str -> patrimonio.setMarca(str), request, "marca");

		repositorio.criar(patrimonio);

		return patrimonio;
	}
}
