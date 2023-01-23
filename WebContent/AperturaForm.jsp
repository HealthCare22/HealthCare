<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<link rel="stylesheet" href="./css/aperturaFormStyle.css">
    	<title>Apertura di un form</title>
	</head>
	<body>
	<jsp:include page="FormNavbar.jsp"></jsp:include>
    <h2 id="Apertura-text">Apertura nuovo form</h2>

     <form method="post" action="AperturaFormServlet">
        <div class="information">
            <input name="topic" type="text" placeholder="Topic">
            <input name="titolo" type="text" placeholder="Titolo">
            <textarea name="descrizione" rows="10" cols="50" placeholder="Descrizione"></textarea>
        </div>

        <div class="button-apertura">
             <input id="apri-form" type="submit" value="Apri form">
        </div>

    </form>
	</body>
</html>