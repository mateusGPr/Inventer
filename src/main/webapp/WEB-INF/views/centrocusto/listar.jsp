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

<nav>
	<a href="${pageContext.request.contextPath}/centrocusto/cadastrar">
		Cadastrar novo Centro de Custo </a>
</nav>

<table class="table">
	<thead>
		<th scope="col">ID</th>
		<th scope="col">Nome</th>
		<th scope="col">Unidade Administrativa</th>
		<th scope="col">CEP</th>
		<th scope="col">Número</th>
		<th scope="col">Logradouro</th>
		<th scope="col">Complemento</th>
		<th scope="col">Bairro</th>
		<th scope="col">Localidade</th>
		<th scope="col">UF</th>
		<th scope="col"></th>
	</thead>
	<tbody>
		<%
		for (CentroCusto pf : centroCustos) {
			out.write("<tr>");

			out.write("<td  scope=\"row\">" + pf.getId() + "</td>");
			out.write("<td>" + pf.getNome() + "</td>");
			out.write("<td>" + pf.getUndAdministrativa() + "</td>");

			out.write("<td>" + pf.getCep() + "</td>");
			out.write("<td>" + pf.getNumero() + "</td>");
			out.write("<td>" + pf.getLogradouro() + "</td>");
			out.write("<td>" + pf.getComplemento() + "</td>");
			out.write("<td>" + pf.getBairro() + "</td>");
			out.write("<td>" + pf.getLocalidade() + "</td>");
			out.write("<td>" + pf.getUf() + "</td>");

			out.write("<td>");

			out.write("<a href=\"" + request.getContextPath() + "/centrocusto/editar?id=" + pf.getId() + "\">editar</a> ");

			out.write("<a href=\"" + request.getContextPath() + "/centrocusto/excluir?id=" + pf.getId() + "\">excluir</a>");

			out.write("</td>");

			out.write("</tr>");
		}
		%>
	</tbody>
</table>
