<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Fruit Picker</title>
</head>
<body>
	<form action="/favorite_fruit" method="POST">
	What is your favorite fruit?
		<#list fruits as fruit>
			<p>
				<input type="radio" name="fruit" value="${fruit}">${fruit}</input>
			</p>
		<#list>
		<input type="submit" value="SUBMIT!">
	</form>	
</body>
</html>