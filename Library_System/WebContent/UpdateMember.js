function getUser(){
	var username=document.getElementById("username").value;
	console.log(username);
	
	var xHttp = new XMLHttpRequest();
	
	xHttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			var data= JSON.parse(this.responseText);
			console.log(data);
			document.getElementById("name").value=data.member_firstname+" "+data.member_lastname;
			document.getElementById("customer_address").value=data.member_address;
			document.getElementById("contact_number").value=data.contact;
			document.getElementById("customer_email").value=data.email;
			document.getElementById("customer_gender").value=data.gender;
				
		}
	}
	xHttp.open("GET" , "Details_Update_user?search_member='"+username+"'",true);
	xHttp.setRequestHeader("Content-Type", "text");
	xHttp.send();	
}


function customer_contactfunction(){
		var contact=document.update.contact_number.value;
		if (isNaN(contact)){
		  alert("Contact must be numbers");

		}
			}
	