<%@page import="java.util.ArrayList"%>
<%@page import="modelo.CentroCusto"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
Collection<CentroCusto> centroCustos = new ArrayList<CentroCusto>();

if (request.getAttribute("centrocusto") != null)
	centroCustos = (Collection<CentroCusto>) request.getAttribute("centrocusto");
%>

<form method="POST"
	action="${pageContext.request.contextPath}/setor/cadastrar">
	<h2>Setor</h2>
	<div class="form-group m-1">
		<label for="nome">Nome:</label> <input class="form-control m-1"
			type="text" name="nome">
	</div>

	<div class="form-group m-1">
		<label for="codigo">Código:</label> <input class="form-control m-1"
			type="text" name="codigo">
	</div>

	<h2>Centro de Custo Vínculado</h2>
	<div class="form-group m-1">
		<select class="form-control m-1" name="ccId">
			<%
			for (CentroCusto pf : centroCustos) {
				out.write("<option value=" + pf.getId() + ">" + pf.getUndAdministrativa() + " - " + pf.getNome() + "</option>");
			}
			%>
		</select>
	</div>
	<h2>Endereço</h2>

	<div class="form-group m-1">
		<label for="cep">CEP:</label> <input class="form-control m-1"
			type="number" name="cep">
	</div>

	<div class="form-group m-1">
		<label for="numero">Número:</label> <input class="form-control m-1"
			type="number" name="numero">
	</div>

	<div class="form-group m-1">
		<label for="logradouro">Logradouro:</label> <input
			class="form-control m-1" type="text" name="logradouro">
	</div>

	<div class="form-group m-1">
		<label for="complemento">Complemento:</label> <input
			class="form-control m-1" type="text" name="complemento">
	</div>

	<div class="form-group m-1">
		<label for="bairro">Bairro:</label> <input class="form-control m-1"
			type="text" name="bairro">
	</div>

	<div class="form-group m-1">
		<label for="localidade">Localidade:</label> <input
			class="form-control m-1" type="text" name="localidade">
	</div>

	<div class="form-group m-1">
		<label for="uf">UF:</label> <input class="form-control m-1"
			type="text" name="uf">
	</div>

	<div class="form-group m-1">
		<input type="submit" class="btn btn-primary" value="Enviar">
	</div>
</form>