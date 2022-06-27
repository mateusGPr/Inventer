<%@page import="modelo.Setor"%>
<%@page import="modelo.Funcionario"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Patrimonio"%>
<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Patrimonio patrimonio = (Patrimonio) request.getAttribute("patrimonio");
Funcionario funcionario = (Funcionario) request.getAttribute("funcionario");
Setor setor = (Setor) request.getAttribute("setor");
%>

<nav>
	<a href="${pageContext.request.contextPath}/patrimonio"> Listar
		Patrim�nios</a>
</nav>

<p>
	<strong>ID:</strong>
	<%=patrimonio.getId()%>
</p>
<p>
	<strong>Nome</strong>
	<%=patrimonio.getNome()%>
</p>
<p>
	<strong>Plaqueta</strong>
	<%=patrimonio.getPlaqueta()%>
</p>
<p>
	<strong>Modelo</strong>
	<%=patrimonio.getModelo()%>
</p>
<p>
	<strong>Estado</strong>
	<%=patrimonio.getEstado()%>
</p>
<p>
	<strong>Situa��o</strong>
	<%=patrimonio.getSituacao()%>
</p>
<p>
	<strong>Num. Serie</strong>
	<%=patrimonio.getNumeroSerie()%>
</p>
<p>
	<strong>Valor</strong>
	<%=patrimonio.getValor()%>
</p>
<p>
	<strong>Marca</strong>
	<%=patrimonio.getMarca()%>
</p>
<h2>Funcion�rio V�nculado</h2>
<p>
	<strong>Prontu�rio:</strong>
	<%=funcionario.getProntuario()%>
</p>
<p>
	<strong>Nome:</strong>
	<%=funcionario.getNome()%>
</p>
<p>
	<strong>CPF:</strong>
	<%=funcionario.getCpf()%>
</p>
<h2>Setor V�nculado</h2>
<p>
	<strong>C�digo:</strong>
	<%=setor.getCodigo()%>
</p>
<p>
	<strong>Nome:</strong>
	<%=setor.getNome()%>
</p>

