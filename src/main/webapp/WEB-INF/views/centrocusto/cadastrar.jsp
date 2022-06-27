<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<form method="POST"
	action="${pageContext.request.contextPath}/centrocusto/cadastrar">
	<h2>Centro Custo</h2>
	<div class="form-group m-1">
		<label for="nome">Nome:</label> <input class="form-control m-1"
			type="text" name="nome">
	</div>

	<div class="form-group m-1">
		<label for="undadm">Unidade Administrativa:</label> <input
			class="form-control m-1" type="text" name="undadm">
	</div>

	<h2>Endereço do Centro de Custo</h2>

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