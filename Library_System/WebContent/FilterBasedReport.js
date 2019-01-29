function getData(){
	var filter=document.getElementById("filter").value;
	console.log(filter);
	if(filter=="subject"){
		getSubjects();
		
	}
	if(filter=="available"){
	var xHttp = new XMLHttpRequest();
		document.getElementById("subject").hidden=true;
		console.log(xHttp);
		xHttp.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200){
				var data= this.responseText;
				console.log(this.status+data);
				document.getElementById("availableDiv").hidden=false;
				document.getElementById("availableDiv").innerHTML=data;
				document.getElementById("subjectDiv").hidden=true;
			}
		}
		xHttp.open("GET","FilterBasedAvailability",true);
		xHttp.setRequestHeader("Content-Type", "text");
		xHttp.send();
	}
	
}

function getSubjects(){
	document.getElementById("subject").hidden=false;
}

function getSubjectData(){
	var xHttp = new XMLHttpRequest();
	var subject=document.getElementById("subject_filter").value;
	console.log(subject+xHttp);
	xHttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			var data=this.responseText;
			console.log(data);
			document.getElementById("subjectDiv").hidden=false;
			document.getElementById("availableDiv").hidden=true;
			document.getElementById("subjectDiv").innerHTML=data;
			
		}
	}
	xHttp.open("GET","FilterBasedSubject?subject="+subject,true);
	xHttp.setRequestHeader("Content-Type", "text");
	xHttp.send();
}