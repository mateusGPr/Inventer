<%@page import="java.util.ArrayList"%>
<%@page import="modelo.CentroCusto"%>
<%@page import="java.util.Collection"%>
<%@page import="modelo.Setor"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Collection<CentroCusto> centroCustos = new ArrayList<CentroCusto>();

if (request.getAttribute("centrocusto") != null)
	centroCustos = (Collection<CentroCusto>) request.getAttribute("centrocusto");

Setor setor = (Setor) request.getAttribute("setor");
CentroCusto currentcc = (CentroCusto) request.getAttribute("currentcc");

if(currentcc == null)
	currentcc = new CentroCusto();
%>

<form method="POST"
	action="${pageContext.request.contextPath}/setor/editar">
	<div class="form-group m-1">
		<label for="nome">Nome:</label> <input type="text"
			class="form-control m-1" name="nome" value="<%=setor.getNome()%>">
		<input type="hidden" name="id" value="<%=setor.getId()%>">
	</div>

	<div class="form-group m-1">
		<label for="codigo">Código:</label> <input type="text"
			class="form-control m-1" name="codigo" value="<%=setor.getCodigo()%>">
	</div>
	<h2>Centro de Custo Vínculado</h2>
	<div class="form-group m-1">
		<select class="form-control m-1" name="ccId">
			<%
			p

			for (CentroCusto pf : centroCustos) {
				String cc = pf.getUndAdministrativa() + " - " + pf.getNome() + "</option>";
				if (pf.getId() == currentcc.getId()) {
					out.write("<option value=" + pf.getId() + " selected>" + cc);
				} else {
					out.write("<option value=" + pf.getId() + ">" + cc);
				}
			}
			%>
		</select>
	</div>
	<h2>Endereço</h2>

	<div class="form-group m-1">
		<label for="cep">CEP:</label> <input type="number"
			class="form-control m-1" name="cep" value="<%=setor.getCep()%>">
	</div>

	<div class="form-group m-1">
		<label for="numero">Número:</label> <input type="number"
			class="form-control m-1" name="numero" value="<%=setor.getNumero()%>">
	</div>

	<div class="form-group m-1">
		<label for="logradouro">Logradouro:</label> <input type="text"
			class="form-control m-1" name="logradouro"
			value="<%=setor.getLogradouro()%>">
	</div>

	<div class="form-group m-1">
		<label for="complemento">Complemento:</label> <input type="text"
			class="form-control m-1" name="complemento"
			value="<%=setor.getComplemento()%>">
	</div>

	<div class="form-group m-1">
		<label for="bairro">Bairro:</label> <input type="text"
			class="form-control m-1" name="bairro" value="<%=setor.getBairro()%>">
	</div>

	<div class="form-group m-1">
		<label for="localidade">Localidade:</label> <input type="text"
			class="form-control m-1" name="localidade"
			value="<%=setor.getLocalidade()%>">
	</div>

	<div class="form-group m-1">
		<label for="uf">UF:</label> <input type="text"
			class="form-control m-1" name="uf" value="<%=setor.getUf()%>">
	</div>

	<div class="form-group m-1">
		<input type="submit" class="btn btn-primary" value="Enviar">
	</div>
</form>