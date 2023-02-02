<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Beans.GestioneMalattieBean" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Elenco malattie rare</title>
<link rel="stylesheet" href="./css/listaMalattieStyle.css">
</head>

<body>
	<jsp:include page="navbar.jsp"/>
	
	<div id="Titolo">
			<h1>Elenco delle malattie rare</h1>
	</div>
		<%List<GestioneMalattieBean>listaMalattie = (List<GestioneMalattieBean>)request.getAttribute("listaMalattie"); %>

		<div id = "elencoMalattie">
		<div id="malattiaContainer">
            <div class="elenco">
             <table>
             <%if(listaMalattie.size()>0){ %>
             	<tr>
             		<th>Nome Malattia</th>
             	</tr>
             		<%
             		
             		for(GestioneMalattieBean m : listaMalattie){ 
             		String nomeMalattia = m.getNome();%>
             		<tr>
             			<td><a id="linkMalattia" href="RicercaPerNomeServlet?nomeMalattia=<%=nomeMalattia%>"><%=nomeMalattia %></a></td>
             		</tr>
             		<%} %>
             </table>
            </div>
		</div> 
		</div>
		<%}else{ %><p>Non ci sono malattie che corrispondono ai sintomi</p>
			<div class="indietroButton">
			<button  id="indietro" onclick="history.back()">Indietro</button>
		</div>
		<%} %>
</body>