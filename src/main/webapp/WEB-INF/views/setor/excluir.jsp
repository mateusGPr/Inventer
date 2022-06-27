<%@page import="modelo.Setor"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Setor setor = (Setor) request.getAttribute("setor");
%>

<p>
	Tem certeza que deseja excluir o cadastro de
	<%=setor.getCodigo() + " - " + setor.getNome()%>?
</p>

<form action="${pageContext.request.contextPath}/setor/excluir"
	method="POST">
	<input type="hidden" name="id" value="<%=setor.getId()%>">
	<p>
		<input type="submit" value="Sim">
	</p>
</form>