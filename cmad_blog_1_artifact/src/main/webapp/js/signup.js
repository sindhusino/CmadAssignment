$(document).ready(function(){
$("#signup-button").click(function(){
var email = $("#signup-text").val();
var password = $("#signup-pass").val();
var userName = $("#username-text").val();
// Checking for blank fields.
if( email =='' || password =='' || userName ==''){
alert("Please fill all fields...!!!!!!");
}else {
	$.ajax({
        type : "POST",
        url : 'blog/user/create',
        dataType :"text",
        contentType: "application/json",
        data : JSON.stringify({name:userName,emailId:email,password:password}),
        success : function(status) {
        	console.log(status);
        	//alert(status+": Successfully inserted");
          window.location= "index.jsp";
        },
        error: function (xhr, status) {
        	console.log(status);
            alert(status +": Data already exists");
        }	
	});
	}
	});
});
