<%@page import="modelo.Funcionario"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Funcionario funcionario = (Funcionario) request.getAttribute("funcionario");
%>

<p>
	Tem certeza que deseja excluir o cadastro de
	<%=funcionario.getProntuario() + " - " + funcionario.getNome()%>?
</p>

<form action="${pageContext.request.contextPath}/funcionario/excluir"
	method="POST">
	<input type="hidden" name="id" value="<%=funcionario.getId()%>">
	<p>
		<input type="submit" value="Sim">
	</p>
</form>