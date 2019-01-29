function getReports(){
		var xHttp = new XMLHttpRequest();
		console.log(xHttp);
		xHttp.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200){
				var jsondata = JSON.parse(xHttp.responseText);
				console.log(jsondata);
				for(var i=0;i<jsondata.length;i++){
					document.getElementById("book_name").value=jsondata[i].book_name;
					document.getElementById("author_name").value=jsondata[i].author_name;
					document.getElementById("number_of_copies").value=jsondata[i].number_of_copies ;
				}
			}
		}
		xHttp.open("GET" , "http://localhost:8089/Library_Restfull_WS/Library_mgt/subject",true);
		xHttp.setRequestHeader("Content-Type", "application/JSON");
		xHttp.send();
}
