<%@page import="modelo.Setor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Funcionario"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
Collection<Funcionario> funcionarios = new ArrayList<Funcionario>();

if (request.getAttribute("funcionarios") != null)
	funcionarios = (Collection<Funcionario>) request.getAttribute("funcionarios");

Collection<Setor> setores = new ArrayList<Setor>();

if (request.getAttribute("setores") != null)
	setores = (Collection<Setor>) request.getAttribute("setores");
%>
<form method="POST"
	action="${pageContext.request.contextPath}/patrimonio/cadastrar">
	<div class="form-group m-1">
		<label for="nome">Nome:</label> <input class="form-control m-1"
			type="text" name="nome">
	</div>

	<div class="form-group m-1">
		<label for="plaqueta">Plaqueta:</label> <input
			class="form-control m-1" type="text" name="plaqueta">
	</div>

	<div class="form-group m-1">
		<label for="modelo">Modelo:</label> <input class="form-control m-1"
			type="text" name="modelo">
	</div>

	<div class="form-group m-1">
		<label for="estado">Estado:</label> <select class="form-control m-1"
			name="estado">
			<option value="Normal">Normal</option>
			<option value="Inservível">Inservível</option>
			<option value="Quebrado">Quebrado</option>
		</select>
	</div>

	<div class="form-group m-1">
		<label for="situacao">Situação:</label> <select
			class="form-control m-1" name="situacao">
			<option value="Não Inventariado">Não Inventariado</option>
			<option value="Não Localizado">Não Localizado</option>
			<option value="Furto">Furto</option>
			<option value="Roubo">Roubo</option>
			<option value="Localizado">Localizado</option>
		</select>
	</div>

	<div class="form-group m-1">
		<label for="numeroSerie">Número de série:</label> <input
			class="form-control m-1" type="text" name="numeroSerie">
	</div>

	<div class="form-group m-1">
		<label for="valor">Valor:</label> <input class="form-control m-1"
			type="number" name="valor" step="0.01">
	</div>

	<div class="form-group m-1">
		<label for="marca">Marca:</label> <input class="form-control m-1"
			type="text" name="marca">
	</div>


	<h2>Funcionário Vínculado</h2>
	<div class="form-group m-1">
		<select class="form-control m-1" name="funcId">
			<%
			for (Funcionario pf : funcionarios) {
				out.write("<option value=" + pf.getId() + ">" + pf.getProntuario() + " - " + pf.getNome() + "</option>");
			}
			%>
		</select>
	</div>
	<h2>Setor Vínculado</h2>
	<div class="form-group m-1">
		<select class="form-control m-1" name="setorId">
			<%
			for (Setor pf : setores) {
				out.write("<option value=" + pf.getId() + ">" + pf.getCodigo() + " - " + pf.getNome() + "</option>");
			}
			%>
		</select>
	</div>
	<div class="form-group m-1">
		<input type="submit" class="btn btn-primary" value="Enviar">
	</div>
</form>