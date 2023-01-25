<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/logout.css">
    <title>Logout</title>
</head>
<body>
    <img class="logo" src="images/logo.png" alt="logoHealthCare">
    <div class="logout">
        <h1 id="labelaccount">Sei sicuro di voler uscire?</h1>

        <div class="pulsantiSiNo">
        <form method="get" action="LogoutServlet">
            <button id = "firstFormButton">Si</button>
         </form>
         <form action="profile.jsp">   
            <button id = "secondFormButton">No</button>
         </form>
        </div>
    </div>
</body>
</html>
