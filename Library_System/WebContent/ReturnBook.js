function date_take(){
		let today = new Date().toISOString().substr(0, 10);
		document.querySelector("#today").value = today;
		}

function getIssueDate(){
	var username=document.getElementById("username").value;
	var bookid=document.getElementById("book_id").value;
	console.log(username,bookid);
	
	var xHttp = new XMLHttpRequest();
	
	xHttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			var data= JSON.parse(this.responseText);
			console.log(data);
			document.getElementById("issue_date").value=data.issue_date;
				
		}
	}
	xHttp.open("GET","Details_Return_Book?search_name="+username+"&search_bookid="+bookid,true);
	xHttp.setRequestHeader("Content-Type", "text");
	xHttp.send();
}
