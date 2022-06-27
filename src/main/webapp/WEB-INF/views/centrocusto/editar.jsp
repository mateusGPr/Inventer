<%@page import="modelo.CentroCusto"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
CentroCusto centroCusto = (CentroCusto) request.getAttribute("centrocusto");
%>

<form method="POST"
	action="${pageContext.request.contextPath}/centrocusto/editar">
	<div class="form-group m-1">
		<label for="nome">Nome:</label> <input type="text"
			class="form-control m-1" name="nome"
			value="<%=centroCusto.getNome()%>"> <input type="hidden"
			name="id" value="<%=centroCusto.getId()%>">
	</div>

	<div class="form-group m-1">
		<label for="undadm">Unidade Administrativa:</label> <input type="text"
			class="form-control m-1" name="undadm"
			value="<%=centroCusto.getUndAdministrativa()%>">
	</div>

	<h2>Endereço do Centro de Custo</h2>

	<div class="form-group m-1">
		<label for="cep">CEP:</label> <input type="number"
			class="form-control m-1" name="cep" value="<%=centroCusto.getCep()%>">
	</div>

	<div class="form-group m-1">
		<label for="numero">Número:</label> <input type="number"
			class="form-control m-1" name="numero"
			value="<%=centroCusto.getNumero()%>">
	</div>

	<div class="form-group m-1">
		<label for="logradouro">Logradouro:</label> <input type="text"
			class="form-control m-1" name="logradouro"
			value="<%=centroCusto.getLogradouro()%>">
	</div>

	<div class="form-group m-1">
		<label for="complemento">Complemento:</label> <input type="text"
			class="form-control m-1" name="complemento"
			value="<%=centroCusto.getComplemento()%>">
	</div>

	<div class="form-group m-1">
		<label for="bairro">Bairro:</label> <input type="text"
			class="form-control m-1" name="bairro"
			value="<%=centroCusto.getBairro()%>">
	</div>

	<div class="form-group m-1">
		<label for="localidade">Localidade:</label> <input type="text"
			class="form-control m-1" name="localidade"
			value="<%=centroCusto.getLocalidade()%>">
	</div>

	<div class="form-group m-1">
		<label for="uf">UF:</label> <input type="text"
			class="form-control m-1" name="uf" value="<%=centroCusto.getUf()%>">
	</div>

	<div class="form-group m-1">
		<input type="submit" class="btn btn-primary" value="Enviar">
	</div>
</form>