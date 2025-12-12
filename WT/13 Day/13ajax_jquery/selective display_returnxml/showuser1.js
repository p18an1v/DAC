$(document).ready(function(){
	var c=0;
	oncha="showUser(this.value)"
  $("#sl").change(function(){
var n=$("#sl option:selected").val();


arr=$("#sl").serializeJSON();
//var arr = {"nm" : n, "pass" : p};
var url="displaybytag.php";
console.log(arr);
alert(url)
       $.post(url,{data:arr},function(d) {
		              alert(d);
					  						 
document.getElementById("firstname").innerHTML=d.getElementsByTagName("firstname")[0].childNodes[0].nodeValue;
document.getElementById("lastname").innerHTML=d.getElementsByTagName("lastname")[0].childNodes[0].nodeValue;
 
document.getElementById("age").innerHTML=d.getElementsByTagName("id")[0].childNodes[0].nodeValue;
  
					                 }).fail(function(x) {
    alert( "error"+x );
  })

});
});
