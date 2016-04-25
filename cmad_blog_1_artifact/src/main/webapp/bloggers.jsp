<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Basics</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/initial.css" />
<link rel="stylesheet" type="text/css" href="css/basics.css" />
<script type="text/javascript" src="scripts/jquery-2.1.3.js"></script>
<script src="js/comment.js"></script>
</head>
<body>
	<div class="outerClass" id="outer">
		<div id="hdr">
			<h1 id="title">Basics</h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="landingPage.jsp">Home</a></li>
				<li><a href="about.jsp">About</a></li>
				<li><a href="contact.jsp">Contact</a></li>
				<li><a href="index.jsp">Logout</a></li>
			</ul>
		</div>
		<div id="cont">
			<h2>Back To Basics</h2>
			<img alt="leaves" src="images/leaves.gif" id="leftImg" />
			<p>Basics is my second submission to this site. It is open
				source, so use it as you please. I called it basics because it is a
				enjoy the template.</p>
			<em>This page validates on the W3C page.</em> <img alt=""
				src="images/leaves.gif" id="rightImg" />
			<h2>Lorem ipsum</h2>
			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed
				ut dui ac lacus egestas vehicula. Quisque faucibus, risus id
				consequat porta, orci ligula condimentum mi, ac commodo leo libero
				Vestibulum massa risus, gravida quis, hendrerit sit amet, bibendum
				sit amet, enim. Fusce nulla. Quisque vulputate metus vitae orci.</p>
			<h2>Lorem ipsum</h2>
			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed
				ut dui ac lacus egestas vehicula. Quisque faucibus, risus id
				consequat porta, orci ligula condimentum mi, ac commodo leo libero
				Pellentesque at arcu. Ut sed neque.</p>
		</div>
		<form name="myform" onSubmit="JavaScript:execute()">
			<textarea name="comments" id="comment"></textarea>
			<div id="comment-button">
			<br>
			<input type="submit" value="Submit"/> 
			</div>
		</form>
	</div>
</html>
