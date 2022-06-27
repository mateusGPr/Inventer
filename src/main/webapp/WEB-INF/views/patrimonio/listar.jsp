<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Patrimonio"%>
<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Collection<Patrimonio> patrimonios = new ArrayList<Patrimonio>();

if (request.getAttribute("patrimonios") != null)
	patrimonios = (Collection<Patrimonio>) request.getAttribute("patrimonios");
%>

<nav>
	<a href="${pageContext.request.contextPath}/patrimonio/cadastrar">
		Cadastrar novo patrimônio </a>
</nav>

<table class="table">
	<thead>
		<th scope="col">ID</th>
		<th scope="col">Nome</th>
		<th scope="col">Plaqueta</th>
		<th scope="col">Modelo</th>
		<th scope="col">Estado</th>
		<th scope="col">Situação</th>
		<th scope="col">Num. Serie</th>
		<th scope="col">Valor</th>
		<th scope="col">Marca</th>
		<th scope="col"></th>
	</thead>
	<tbody>
		<%
		for (Patrimonio pf : patrimonios) {
			out.write("<tr>");

			out.write("<td  scope=\"row\">" + pf.getId() + "</td>");
			out.write("<td><a href=\"" + request.getContextPath() + "/patrimonio/info?id=" + pf.getId() + "\">" + pf.getNome() + "</a></td>");
			out.write("<td>" + pf.getPlaqueta() + "</td>");
			out.write("<td>" + pf.getModelo() + "</td>");
			out.write("<td>" + pf.getEstado() + "</td>");
			out.write("<td>" + pf.getSituacao() + "</td>");
			out.write("<td>" + pf.getNumeroSerie() + "</td>");
			out.write("<td>" + pf.getValor() + "</td>");
			out.write("<td>" + pf.getMarca() + "</td>");

			out.write("<td>");

			out.write("<a href=\"" + request.getContextPath() + "/patrimonio/editar?id=" + pf.getId() + "\">editar</a> ");

			out.write("<a href=\"" + request.getContextPath() + "/patrimonio/excluir?id=" + pf.getId() + "\">excluir</a>");

			out.write("</td>");

			out.write("</tr>");
		}
		%>
	</tbody>
</table>
