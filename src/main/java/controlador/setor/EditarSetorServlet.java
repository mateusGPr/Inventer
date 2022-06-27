package controlador.setor;

import java.io.IOException;

import controlador.Assign;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Setor;
import modelo.repositorio.SetorRepositorio;
import modelo.repositorio.config.PersistenceConfig;

@WebServlet("/setor/editar")
public class EditarSetorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarSetorServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		Long setorId = 0l;
		Setor setor = null;

		try
		{
			setorId = Long.parseLong(request.getParameter("id").trim());

			SetorRepositorio repositorio =
					new SetorRepositorio();

			setor = repositorio.recuperarPorId(setorId);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if(setor == null)
			setor = new Setor();

		request.setAttribute("setor", setor);

		request.setAttribute("tituloPagina",
				"Editar Setor");

		request.setAttribute("pathView",
				"/WEB-INF/views/setor/editar.jsp");

		RequestDispatcher rd =
				request.getRequestDispatcher("/WEB-INF/template.jsp");

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		Long id = 0l;

		try
		{
			id = Long.parseLong(request.getParameter("id").trim());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if(id > 0)
		{
			SetorRepositorio repositorio = new SetorRepositorio();

			Setor setor = repositorio.recuperarPorId(id);

			Assign.Value((str) -> setor.setNome(str), request, "nome");
			Assign.Value((str) -> setor.setCodigo(Long.parseLong(str)), request, "codigo");

			/* Class Endereco */
			Assign.Value((str) -> setor.setCep(Long.parseLong(str)), request, "cep");
			Assign.Value((str) -> setor.setNumero(Integer.parseInt(str)), request, "numero");
			Assign.Value((str) -> setor.setLogradouro(str), request, "logradouro");
			Assign.Value((str) -> setor.setComplemento(str), request, "complemento");
			Assign.Value((str) -> setor.setBairro(str), request, "bairro");
			Assign.Value((str) -> setor.setLocalidade(str), request, "localidade");
			Assign.Value((str) -> setor.setUf(str), request, "uf");

			repositorio.atualizar(setor);

			PersistenceConfig.closeEntityManager();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/setor");

		rd.forward(request, response);
	}
}