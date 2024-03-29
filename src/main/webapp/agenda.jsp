<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.ArrayList" %>
<%
    
    ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");

    
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title></title>
<link rel="icon" href="imagens/fone">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<h1>Agenda de contatos</h1>
	<a href="novo.html" class="botao">Novo contato</a>
	<a href="index.html" class="botao">Voltar</a>
	
	<table id="tabela">
	
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>Email</th>
				<th>Opções</th>
			</tr>
		</thead>
		
		<tbody>
			<% for (int i =0; i < lista.size(); i++) { %>
				<tr>
					<td> <%=lista.get(i).getId() %> </td>
					<td> <%=lista.get(i).getNome() %> </td>
					<td> <%=lista.get(i).getFone() %> </td>
					<td> <%=lista.get(i).getEmail() %> </td>
					<td>
						 <a href="select?id=<%=lista.get(i).getId() %>" class="botao">Editar</a>
						 <a href="delete?id=<%=lista.get(i).getId() %>" onclick="confirmar(<%=lista.get(i).getId() %>)" class="botao2">Excluir</a> 
					</td>
				</tr>
			<% } %>
		</tbody>
	
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>