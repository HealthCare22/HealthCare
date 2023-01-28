<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "Beans.MMGBean" %>
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
            <li><a href="MyForm.jsp">Form</a></li>
            <li><a href="ListaMalattieServlet">Malattia</a></li>
            <li><a href="profile.jsp">Profilo</a></li>
          </ul>

          <ul class="list-item-dx">
            <li id="Notifiche"><a href="./notifiche.jsp">Notifiche</a></li>
            <li><a href="logout.jsp" id="Logout">Logout</a>
            </li>
          </ul>
        </nav>
      </header>
    </body>
  </html>