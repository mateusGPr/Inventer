<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<%
String tituloPagina = "Index";
String pathView = "/index";

if (request.getAttribute("tituloPagina") != null)
	tituloPagina = (String) request.getAttribute("tituloPagina");

if (request.getAttribute("pathView") != null)
	pathView = (String) request.getAttribute("pathView");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title><%=tituloPagina%></title>
<link href="${pageContext.request.contextPath}/static/css/styles.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/custom.css"
	rel="stylesheet">
</head>

<body>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<div class="border-end bg-white" id="sidebar-wrapper">
			<div class="sidebar-heading border-bottom bg-light">Inventer</div>
			<div class="list-group list-group-flush">
				<a
					class="list-group-item list-group-item-action list-group-item-light p-3"
					href="${pageContext.request.contextPath}/patrimonio">Patrimônios</a>
				<a
					class="list-group-item list-group-item-action list-group-item-light p-3"
					href="${pageContext.request.contextPath}/funcionario/patrimonio">Patrimônios
					por Funcionários</a> <a
					class="list-group-item list-group-item-action list-group-item-light p-3"
					href="${pageContext.request.contextPath}/setor/patrimonio">Patrimônios
					por Setores</a> <a
					class="list-group-item list-group-item-action list-group-item-light p-3"
					href="${pageContext.request.contextPath}/centrocusto">Centros
					de Custo</a> <a
					class="list-group-item list-group-item-action list-group-item-light p-3"
					href="${pageContext.request.contextPath}/setor">Setores</a> <a
					class="list-group-item list-group-item-action list-group-item-light p-3"
					href="${pageContext.request.contextPath}/funcionario">Funcionários</a>
			</div>
		</div>
		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<!-- Top navigation-->
			<nav
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
				<div class="container-fluid">
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mt-2 mt-lg-0">
							<li class="nav-item"><button class="btn btn-default"
									id="sidebarToggle">&#8646;</button></li>
							<li class="nav-item active"><a class="nav-link"
								href="${pageContext.request.contextPath}/index">Home</a></li>

							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
								role="button" data-bs-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">Listar</a>
								<div class="dropdown-menu dropdown-menu-end"
									aria-labelledby="navbarDropdown">
									<a class="dropdown-item"
										href="${pageContext.request.contextPath}/centrocusto">Centros
										de Custo</a> <a class="dropdown-item"
										href="${pageContext.request.contextPath}/setor">Setores</a> <a
										class="dropdown-item"
										href="${pageContext.request.contextPath}/funcionario">Funcionários</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item"
										href="${pageContext.request.contextPath}/patrimonio">Patrimônios</a>
									<a class="dropdown-item"
										href="${pageContext.request.contextPath}/setor/patrimonio">Patrimônios
										por Setores</a> <a class="dropdown-item"
										href="${pageContext.request.contextPath}/funcionario/patrimonio">Patrimônios
										por Funcionário</a>
								</div></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
								role="button" data-bs-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">Cadastrar</a>
								<div class="dropdown-menu dropdown-menu-end"
									aria-labelledby="navbarDropdown">
									<a class="dropdown-item"
										href="${pageContext.request.contextPath}/centrocusto/cadastrar">+
										Centro de Custo</a> <a class="dropdown-item"
										href="${pageContext.request.contextPath}/setor/cadastrar">+
										Setor</a> <a class="dropdown-item"
										href="${pageContext.request.contextPath}/funcionario/cadastrar">+
										Funcionário</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item"
										href="${pageContext.request.contextPath}/patrimonio/cadastrar">+
										Patrimônio</a>
								</div></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- Page content-->
			<div class="container-fluid">
				<main>
					<h1><%=tituloPagina%></h1>
					<jsp:include page="${pathView}" />
				</main>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/js/scripts.js"
		type="text/javascript"></script>
</body>
</html>