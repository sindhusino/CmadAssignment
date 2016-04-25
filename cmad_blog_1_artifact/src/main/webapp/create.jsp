<html>
<head>
<title>Design Blog</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/landingstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-2.1.3.js"></script>
<!--[if lt IE 7]><style type="text/css">div { behavior: url(iepngfix.htc); }</style><![endif]-->
<script src="js/create.js"></script>
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="logo">
				<div id="site_slogan">free CSS website template</div>
			</div>
		</div>
		<div id="menu">
			<ul>
				<li><a href="landingPage.jsp">Home</a></li>
				<li><a href="contact.jsp">Contact</a></li>
				<li><a href="index.jsp">Logout</a></li>
			</ul>
		</div>
		<div id="content">
			<div id="left_column">
				<div class="postbody">
					<h1>POST Your Query</h1>
				</div>
			</div>
		</div>
		<form name="myform" onSubmit="JavaScript:execute()">
			<b id="titletag">Title:</b><textarea name="title" id="title"></textarea>
			<b id="descriptiontag">Description:</b><textarea name="comments" id="description"></textarea>
			<div id="comment-button">
			<br>
			<input id="Submit-button" type="submit" value="Submit"/> 
			</div>
		</form>
	</div>

</body>
</html>