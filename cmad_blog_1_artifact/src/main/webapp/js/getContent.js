function getdata(){
	$.ajax({
        type : "GET",
        url : 'blog/user/blogs',
        dataType :"json",
        contentType: "application/json",
        success : function(data, status) {
        	console.log(data);
        	var rowTemplate = $("#templates table").html();
			console.log("template:" + rowTemplate);
				console.log(JSON.stringify(data));
				for(index in data) {
				var row = rowTemplate.replace("name",data[index].name)
							.replace("emailId",data[index].emailId)
							.replace("password",data[index].password);
				$("#data").append(row);
				}
},
});
	window.location = "landingPage.jsp";
}