function execute() {
	var titleHdr = $("#titleContent").text();
	alert(titleHdr);
	if (titleHdr == '') {
		alert("Cannot post empty query...!!!!!!");
	} else {
		$.ajax({
			type : "GET",
			url : 'blog/page/blogpagetitle/'+titleHdr,
			dataType : "json",
			contentType : "application/json",
			success : handleData(status),
			error : function(xhr, status) {
				console.log(status);
				alert(status);
			},
		});
	}
	function handleData(status) {
		console.log("data: " + status);
		alert("Success");
		window.location = "bloggers.jsp";
		// $.ajax({
		// type : "GET",
		// url : 'blog/user/create/query',
		// dataType : "json",
		// contentType : "application/json",
		// success : function(data, status) {
		// console.log(data);
		//			
		// },
		// });
	}
}
