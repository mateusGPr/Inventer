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

@WebServlet("/patrimonio/editar")
public class EditarPatrimonioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarPatrimonioServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Collection<Funcionario> funcionarios = null;
		Collection<Setor> setores = null;
		Funcionario funcionario = null;
		Patrimonio patrimonio = null;
		Setor setor = null;
		Long patrimonioId = 0l;

		try {
			patrimonioId = Long.parseLong(request.getParameter("id").trim());

			final FuncionarioRepositorio repositorioFN = new FuncionarioRepositorio();
			final PatrimonioRepositorio repositorio = new PatrimonioRepositorio();
			final SetorRepositorio repositorioST = new SetorRepositorio();

			setores = repositorioST.recuperar();
			funcionarios = repositorioFN.recuperar();

			setor = repositorio.recuperarSetorById(patrimonioId);
			funcionario = repositorio.recuperarFuncionarioById(patrimonioId);

			PersistenceConfig.closeEntityManager();

			patrimonio = repositorio.recuperarPorId(patrimonioId);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (patrimonio == null) {
			patrimonio = new Patrimonio();
		}

		request.setAttribute("funcionarios", funcionarios);
		request.setAttribute("funcionario", funcionario);
		request.setAttribute("setores", setores);
		request.setAttribute("setor", setor);
		request.setAttribute("patrimonio", patrimonio);

		request.setAttribute("tituloPagina", "Editar Patrimônio");

		request.setAttribute("pathView", "/WEB-INF/views/patrimonio/editar.jsp");

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
			final Long patId = Long.parseLong(request.getParameter("id").trim());

			if (setorId < 1 || funcId < 1) {
				throw new Exception("setorId ou funcId não definido.");
			}

			final Setor setor = setorRepo.recuperarPorId(setorId);
			final Funcionario funcionario = funcRepo.recuperarPorId(funcId);

			final Setor curSetor = repositorio.recuperarSetorById(patId);
			final Funcionario curFuncionario = repositorio.recuperarFuncionarioById(patId);

			if (setor == null || funcionario == null) {
				throw new Exception("Não foi possível localizar o Setor ou o Funcionário.");
			}

			final Patrimonio patrimonio = PersistPatrimonio(repositorio, patId, request);

			if (curSetor != setor) {
				if (curSetor != null) {
					curSetor.getPatrimonios().remove(patrimonio);
					setorRepo.atualizar(curSetor);
				}
				setor.getPatrimonios().add(patrimonio);
				setorRepo.atualizar(setor);
			}
			if (curFuncionario != funcionario) {
				if (curFuncionario != null) {
					curFuncionario.getPatrimonios().remove(patrimonio);
					funcRepo.atualizar(curFuncionario);
				}
				funcionario.getPatrimonios().add(patrimonio);
				funcRepo.atualizar(funcionario);
			}
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			PersistenceConfig.closeEntityManager();
		}

		final RequestDispatcher rd = request.getRequestDispatcher("/patrimonio");

		rd.forward(request, response);
	}

	protected Patrimonio PersistPatrimonio(PatrimonioRepositorio repositorio, Long id, HttpServletRequest request) {
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
		return patrimonio;
	}
}
