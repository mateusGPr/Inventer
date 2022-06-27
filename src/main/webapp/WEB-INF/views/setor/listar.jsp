<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Setor"%>
<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Collection<Setor> setores = new ArrayList<Setor>();

if (request.getAttribute("setores") != null)
	setores = (Collection<Setor>) request.getAttribute("setores");
%>

<nav>
	<a href="${pageContext.request.contextPath}/setor/cadastrar">
		Cadastrar novo setor</a>
</nav>

<table class="table">
	<thead>
		<th scope="col">ID</th>
		<th scope="col">Nome</th>
		<th scope="col">Código</th>
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
		for (Setor pf : setores) {
			out.write("<tr>");

			out.write("<td  scope=\"row\">" + pf.getId() + "</td>");
			out.write("<td>" + pf.getNome() + "</td>");
			out.write("<td>" + pf.getCodigo() + "</td>");
			

			out.write("<td>" + pf.getCep() + "</td>");
			out.write("<td>" + pf.getNumero() + "</td>");
			out.write("<td>" + pf.getLogradouro() + "</td>");
			out.write("<td>" + pf.getComplemento() + "</td>");
			out.write("<td>" + pf.getBairro() + "</td>");
			out.write("<td>" + pf.getLocalidade() + "</td>");
			out.write("<td>" + pf.getUf() + "</td>");

			out.write("<td>");

			out.write("<a href=\"" + request.getContextPath() + "/setor/editar?id=" + pf.getId() + "\">editar</a> ");

			out.write("<a href=\"" + request.getContextPath() + "/setor/excluir?id=" + pf.getId() + "\">excluir</a>");

			out.write("</td>");

			out.write("</tr>");
		}
		%>
	</tbody>
</table>
