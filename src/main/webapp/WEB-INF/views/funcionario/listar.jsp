<%@page import="modelo.Funcionario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Collection<Funcionario> funcionarios = new ArrayList<Funcionario>();

if (request.getAttribute("funcionarios") != null)
	funcionarios = (Collection<Funcionario>) request.getAttribute("funcionarios");
%>

<nav>
	<a href="${pageContext.request.contextPath}/funcionario/cadastrar">
		Cadastrar novo funcionário </a>
</nav>

<table class="table">
	<thead>
		<th scope="col">ID</th>
		<th scope="col">Nome</th>
		<th scope="col">CPF</th>
		<th scope="col">Prontuário</th>
		<th scope="col">Cargo</th>
		<th scope="col"></th>
	</thead>
	<tbody>
		<%
		for (Funcionario pf : funcionarios) {
			out.write("<tr>");

			out.write("<td  scope=\"row\">" + pf.getId() + "</td>");
			out.write("<td>" + pf.getNome() + "</td>");
			out.write("<td>" + pf.getCpf() + "</td>");
			out.write("<td>" + pf.getProntuario() + "</td>");
			out.write("<td>" + pf.getCargo() + "</td>");

			out.write("<td>");

			out.write("<a href=\"" + request.getContextPath() + "/funcionario/editar?id=" + pf.getId() + "\">editar</a> ");

			out.write("<a href=\"" + request.getContextPath() + "/funcionario/excluir?id=" + pf.getId() + "\">excluir</a>");

			out.write("</td>");

			out.write("</tr>");
		}
		%>
	</tbody>
</table>
