$(document).ready(function(){
$("#login-button").click(function(){
var email = $("#login-text").val();
var password = $("#login-pass").val();
// Checking for blank fields.
if( email =='' || password ==''){
alert("Please fill all fields...!!!!!!");
}else {
	$.ajax({
        type : "POST",
        url : 'blog/user/check/email',
        dataType :"text",
        contentType: "application/json",
        data : JSON.stringify({emailId:email,password:password}),
        success : function(data, status) {
        	//alert(status+": Valid User");
        	window.location = "index2.jsp";
        },
        error: function (xhr, status) {
        	console.log(status);
            alert(status +": Invalid email-Id or Password");
        }	
});
	

}
});
});