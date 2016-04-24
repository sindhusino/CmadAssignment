$(document).ready(function(){
$("#login-button").click(function(){
var email = $("#login-text").val();
var password = $("#login-pass").val();
// Checking for blank fields.
	$.ajax({
        type : "POST",
        url : 'blog/page/blogpage',
        dataType :"text",
        contentType: "application/json",
        data : JSON.stringify({"postTitle":"title1","postAbout":"about1","postTags":"tag1","postEmail":"sins@cisco.com"}),
        success : function(data, status) {
        	//alert(status+": Valid User");
        	window.location = "index2.jsp";
        },
        error: function (xhr, status) {
        	console.log(status);
            alert(status +": Invalid email-Id or Password");
        }	
});
	


});
});