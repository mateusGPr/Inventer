<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<form method="POST"
	action="${pageContext.request.contextPath}/funcionario/cadastrar">
	<div class="form-group m-1">
		<label for="nome">Nome:</label> <input class="form-control m-1"
			type="text" name="nome">
	</div>
	<div class="form-group m-1">
		<label for="cpf">CPF:</label> <input class="form-control m-1"
			type="text" name="cpf">
	</div>
	<div class="form-group m-1">
		<label for="prontuario">Prontuário:</label> <input
			class="form-control m-1" type="number" name="prontuario">
	</div>
	<div class="form-group m-1">
		<label for="cargo">Cargo:</label> <input class="form-control m-1"
			type="text" name="cargo">
	</div>
	<div class="form-group m-1">
		<input type="submit" class="btn btn-primary" value="Enviar">
	</div>
</form>