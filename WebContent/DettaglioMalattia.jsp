 <%
	Collection<?> malattia = (Collection<?>) request.getAttribute("listaMalattia");
 	
 if(malattia == null) {
		response.sendRedirect("./RicercaPerNomeServlet");
		return;
	}
 	
 	System.out.println(malattia);

%>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,Beans.GestioneMalattieBean"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dettaglio Malattia</title>
</head>
<body>

 <% 
  if(malattia != null && malattia.size() != 0){
		Iterator<?> it = malattia.iterator();
		while (it.hasNext()) {
			GestioneMalattieBean bean = (GestioneMalattieBean) it.next();

%>
    <div class="vista-malattia">
        <table>
            <tr>
                <td><%=bean.getIdMalattia()%></td>
                <td><%=bean.getNome()%></td>
                <td><%=bean.getDescrizione()%></td>
            </tr>
        </table>


    </div>
    
<%
		}
  }
	 else {
%>

	<p>No diseases available</p>

<%
	}
	
%>


</body>
</html>