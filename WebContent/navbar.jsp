<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "medico.MMGBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/navbar.css">
    <title>Profilo</title>

</head> 
<body>
    <header>
        <nav>
          <div class="logo">
            <img src="./images/logo.png" />
          </div>
          <ul class="list-item">
            <li><a href="RicercaMalattia.jsp">Ricerca</a></li>
            <li><a href="MyFormServlet">Form</a></li>
            <li><a href="ListaMalattieServlet">Malattia</a></li>
            <li><a href="ProfileServlet">Profilo</a></li>
          </ul>

          <ul class="list-item-dx">
            <li><a href="logout.jsp" id="Logout">Logout</a>
            </li>
          </ul>
        </nav>
      </header>
    </body>
  </html>