package controlador.setor;

import java.io.IOException;

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

@WebServlet("/setor/excluir")
public class ExcluirSetorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirSetorServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long setorId = 0l;
		Setor setor = null;

		try {
			setorId = Long.parseLong(request.getParameter("id").trim());

			SetorRepositorio repositorio = new SetorRepositorio();

			setor = repositorio.recuperarPorId(setorId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (setor == null)
			setor = new Setor();

		request.setAttribute("setor", setor);

		request.setAttribute("tituloPagina", "Excluir Setor");

		request.setAttribute("pathView", "/WEB-INF/views/setor/excluir.jsp");

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long patrimonioId = 0l;

		try {
			patrimonioId = Long.parseLong(request.getParameter("id").trim());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (patrimonioId > 0) {
			SetorRepositorio repositorio = new SetorRepositorio();

			Setor setor = repositorio.recuperarPorId(patrimonioId);
			CentroCusto centroCusto = repositorio.recuperarCentroCustoById(patrimonioId);
			
			if(centroCusto != null) {
				var ccRepo = new CentroCustoRepositorio();
				
				centroCusto.getSetores().remove(setor);
				ccRepo.atualizar(centroCusto);
			}
			
			repositorio.excluir(setor);

			PersistenceConfig.closeEntityManager();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/setor");

		rd.forward(request, response);
	}
}