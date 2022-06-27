<%@page import="modelo.Patrimonio"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Patrimonio patrimonio = (Patrimonio) request.getAttribute("patrimonio");
%>

<p>
	Tem certeza que deseja excluir o cadastro de
	<%=patrimonio.getPlaqueta() + " - " + patrimonio.getNome()%>?
</p>

<form action="${pageContext.request.contextPath}/patrimonio/excluir"
	method="POST">
	<input type="hidden" name="id" value="<%=patrimonio.getId()%>">
	<p>
		<input type="submit" value="Sim">
	</p>
</form>