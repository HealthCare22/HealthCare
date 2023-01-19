<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=, initial-scale=1.0">
<link rel="stylesheet" href="./css/loginstyle.css">
<title>Login</title>
</head>
<body>


	<img class="logo" src="images/logo.png" alt="logoHealthCare">

	<div class="login">
		<h1 id="labelaccount">Accedi ad Health Care</h1>
	<form method="post" action="LoginServlet">
		<div class="LoginInformation">
			<div>
				<input name="email" class="email" type="email" placeholder="Email">
			</div>

			<div>
				<input name="password" class="password" type="password" placeholder="Password">
			</div>


			<div class="passwordDimenticata">
				<a href="">Password dimenticata?</a>
			</div>
		</div>

		<div class="pulsanteAccedi">
			<button type="submit">Accedi</button>
		</div>
		</form>

		<div class="iscriviti">
			<p id="noaccount">Non hai un account?</p>
			<button id="iscriviti">Iscriviti</button>
		</div>

	</div>
</body>
</html>