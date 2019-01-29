function customer_firstnamefunction(){
var name=document.register.customer_firstname.value;
if (!isNaN(name) ){
  alert("Name must have characters");

}
	}
function customer_lastnamefunction(){
		var name=document.register.customer_lastname.value;
		if (!isNaN(name)){
		  alert("Name must be characters");

		}
			}
	
function customer_contactfunction(){
		var contact=document.register.contact_number.value;
		if (isNaN(contact)){
		  alert("Contact must be numbers");

		}
			}
	