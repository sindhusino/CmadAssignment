function execute () {
		var queryPost = $("#comment").val();
		alert(queryPost);
		if (queryPost == '') {
			alert("Cannot post empty query...!!!!!!");
		} else {
			$.ajax({
				type : "POST",
				url : 'blog/user/createQuery',
				dataType :"json",
		        contentType: "application/json",
				data : JSON.stringify({query:queryPost}),
				success : handleData(status),
				error : function(xhr, status) {
					console.log(status);
					console.log(xhr);
					alert(status);
				},
			});
		}
		function handleData(status) {
			console.log("data: " + status);
			alert("Success");
//			 $.ajax({
//			 type : "GET",
//			 url : 'blog/user/create/query',
//			 dataType : "json",
//			 contentType : "application/json",
//			 success : function(data, status) {
//			 console.log(data);
//			
//			 },
//			 });
		}
};