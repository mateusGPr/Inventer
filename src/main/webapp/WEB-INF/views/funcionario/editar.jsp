<%@page import="modelo.Funcionario"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Funcionario funcionario = (Funcionario) request.getAttribute("funcionario");
%>

<form method="POST"
	action="${pageContext.request.contextPath}/funcionario/editar">
	<div class="form-group m-1">
		<label for="nome">Nome:</label> <input type="text"
			class="form-control m-1" name="nome"
			value="<%=funcionario.getNome()%>"> <input type="hidden"
			name="id" value="<%=funcionario.getId()%>">
	</div>
	<div class="form-group m-1">
		<label for="cpf">CPF:</label> <input type="text"
			class="form-control m-1" name="cpf" value="<%=funcionario.getCpf()%>">
	</div>
	<div class="form-group m-1">
		<label for="prontuario">Prontuário:</label> <input type="number"
			class="form-control m-1" name="prontuario"
			value="<%=funcionario.getProntuario()%>">
	</div>
	<div class="form-group m-1">
		<label for="cargo">Cargo:</label> <input type="text"
			class="form-control m-1" name="cargo"
			value="<%=funcionario.getCargo()%>">
	</div>
	<div class="form-group m-1">
		<input type="submit" class="btn btn-primary" value="Enviar">
	</div>
</form>