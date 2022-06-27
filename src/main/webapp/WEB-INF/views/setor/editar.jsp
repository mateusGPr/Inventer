<%@page import="modelo.Setor"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Setor setor = (Setor) request.getAttribute("setor");
%>

<form method="POST"
	action="${pageContext.request.contextPath}/setor/editar">
	<div class="form-group m-1">
		<label for="nome">Nome:</label> <input type="text" class="form-control m-1" name="nome"
			value="<%=setor.getNome()%>"> <input type="hidden"
			name="id" value="<%=setor.getId()%>">
	</div>

	<div class="form-group m-1">
		<label for="codigo">Código:</label>
		<input type="text" class="form-control m-1" name="codigo" value="<%=setor.getCodigo()%>">
	</div>
	
	<h2>Endereço</h2>
	
	<div class="form-group m-1">
		<label for="cep">CEP:</label>
		<input type="number" class="form-control m-1" name="cep" value="<%=setor.getCep()%>">
	</div>
	
	<div class="form-group m-1">
		<label for="numero">Número:</label>
		<input type="number" class="form-control m-1" name="numero" value="<%=setor.getNumero()%>">
	</div>
	
	<div class="form-group m-1">
		<label for="logradouro">Logradouro:</label>
		<input type="text" class="form-control m-1" name="logradouro" value="<%=setor.getLogradouro()%>">
	</div>
	
	<div class="form-group m-1">
		<label for="complemento">Complemento:</label>
		<input type="text" class="form-control m-1" name="complemento" value="<%=setor.getComplemento()%>">
	</div>
	
	<div class="form-group m-1">
		<label for="bairro">Bairro:</label>
		<input type="text" class="form-control m-1" name="bairro" value="<%=setor.getBairro()%>">
	</div>
	
	<div class="form-group m-1">
		<label for="localidade">Localidade:</label>
		<input type="text" class="form-control m-1" name="localidade" value="<%=setor.getLocalidade()%>">
	</div>
	
	<div class="form-group m-1">
		<label for="uf">UF:</label>
		<input type="text" class="form-control m-1" name="uf" value="<%=setor.getUf()%>">
	</div>
	
	<div class="form-group m-1">
		<input type="submit" class="btn btn-primary" value="Enviar">
	</div>
</form>