<html>
<head>
<meta charset="UTF-8">
<title>Sign In form</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="scripts/jquery-2.1.3.js"></script>
<script src="js/style.js"></script>
<script src="js/login.js"></script>
<script src="js/signup.js"></script>
</head>
  	<body>
		<div id="tabs">
			<ul>
				<li onClick="showLogin()" id="loginbutton">Login</li>
				<li onClick="showReg()" id="regbutton">Register</li>
			</ul>
		</div> <!-- end tabs div -->
		<div id="wrapper">
			<div id="login-wrapper">
				<br/>
				<h1 style="color: #FFF; width: 360px; margin-left: 20px; font-family: Segoe UI Light; font-weight: 100;">Login</h1>
				<div id="info">Please enter your username and password to login</div>
					<input type="text" id="login-text" placeholder="Username" />
					<input type="password" id="login-pass" placeholder="Password" />
				<input type="button" name ="login" value="Login" id="login-button" />
			</div> <!-- end login-wrapper div -->
			<div id="reg-wrapper">
			<br/>
				<h1 style="color: #FFF; width: 360px; margin-left: 20px; font-family: Segoe UI Light; font-weight: 100;">Register</h1>
				<div id="info">Please enter the below details</div>
					<input type="text" id="username-text" placeholder="Username" />
					<input type="text" id="signup-text" placeholder="email" />
					<input type="password" id="signup-pass" placeholder="Password" />
				<input type="button" name ="Signup" value="Sign Up" id="signup-button" />			
			</div> <!-- end reg-wrapper div -->
		</div> <!-- end wrapper div -->
      <p style="text-align: center;">
	</body>
</html>
