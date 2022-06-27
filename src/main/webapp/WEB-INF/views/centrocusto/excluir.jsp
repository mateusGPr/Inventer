<%@page import="modelo.CentroCusto"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
CentroCusto centroCusto = (CentroCusto) request.getAttribute("centrocusto");
%>

<p>
	Tem certeza que deseja excluir o cadastro de
	<%=centroCusto.getUndAdministrativa() + " - " + centroCusto.getNome()%>?
</p>

<form action="${pageContext.request.contextPath}/centrocusto/excluir"
	method="POST">
	<input type="hidden" name="id" value="<%=centroCusto.getId()%>">
	<p>
		<input type="submit" value="Sim">
	</p>
</form>