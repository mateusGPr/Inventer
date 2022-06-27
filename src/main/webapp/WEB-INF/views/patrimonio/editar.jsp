<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Patrimonio"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Patrimonio patrimonio = (Patrimonio) request.getAttribute("patrimonio");
%>

<form method="POST"
	action="${pageContext.request.contextPath}/patrimonio/editar">
	<div class="form-group m-1">
		<label for="nome">Nome:</label> <input type="text"
			class="form-control m-1" name="nome"
			value="<%=patrimonio.getNome()%>"> <input type="hidden"
			name="id" value="<%=patrimonio.getId()%>">
	</div>

	<div class="form-group m-1">
		<label for="plaqueta">plaqueta:</label> <input type="text"
			class="form-control m-1" name="plaqueta"
			value="<%=patrimonio.getPlaqueta()%>">
	</div>

	<div class="form-group m-1">
		<label for="modelo">modelo:</label> <input type="text"
			class="form-control m-1" name="modelo"
			value="<%=patrimonio.getModelo()%>">
	</div>

	<div class="form-group m-1">
		<label for="estado">Estado:</label> <select class="form-control m-1"
			name="estado">
			<%
			ArrayList<String> list = new ArrayList<String>(Arrays.asList("Normal", "Inservível", "Quebrado"));

			for (String str : list) {
				if (str.contains(patrimonio.getEstado())) {
					out.write("<option value=" + str + " selected>" + str + "</option>");
				} else {
					out.write("<option value=" + str + ">" + str + "</option>");
				}
			}
			%>
		</select>
	</div>

	<div class="form-group m-1">
		<label for="situacao">Situação:</label> <select
			class="form-control m-1" name="situacao">
			<%
			list = new ArrayList<String>(
					Arrays.asList("Não Inventariado", "Não Localizado", "Furto", "Roubo", "Localizado"));

			for (String str : list) {
				if (str.contains(patrimonio.getSituacao())) {
					out.write("<option value=" + str + " selected>" + str + "</option>");
				} else {
					out.write("<option value=" + str + ">" + str + "</option>");
				}
			}
			%>
		</select>
	</div>

	<div class="form-group m-1">
		<label for="numeroSerie">Número de série:</label> <input type="text"
			class="form-control m-1" name="numeroSerie"
			value="<%=patrimonio.getNumeroSerie()%>">
	</div>

	<div class="form-group m-1">
		<label for="valor">Valor:</label> <input type="number"
			class="form-control m-1" name="valor" step="0.01"
			value="<%=patrimonio.getValor()%>">
	</div>

	<div class="form-group m-1">
		<label for="marca">Marca:</label> <input type="text"
			class="form-control m-1" name="marca"
			value="<%=patrimonio.getMarca()%>">
	</div>

	<div class="form-group m-1">
		<input type="submit" class="btn btn-primary" value="Enviar">
	</div>
</form>