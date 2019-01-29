function getAllReports(){
	
	var xHttp = new XMLHttpRequest();
	console.log(xHttp);
	xHttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			
			document.getElementById("detailDiv12").innerHTML=this.responseText;
			
		}
	}
	xHttp.open("GET" , "ReportsForAll",true);
	xHttp.setRequestHeader("Content-Type", "text");
	xHttp.send();	
}

function getParticularUser(){
	var username=document.getElementById("username").value;
	console.log(username);
	var xHttp = new XMLHttpRequest();
	console.log(xHttp);
	xHttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			document.getElementById("detailDiv12").hidden=true;
			document.getElementById("detailDiv").innerHTML=this.responseText;
			
		}
	}
	xHttp.open("GET" ,"ReportForParticularUser?username="+username,true);
	xHttp.setRequestHeader("Content-Type", "text");
	xHttp.send();	
}