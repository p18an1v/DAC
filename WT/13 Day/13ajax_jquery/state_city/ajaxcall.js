$(document).ready(function(){
	
  $("#sl").change(function(){
var n=$("#sl option:selected").val();



var arr = n;
var url="displaybystate.php";
console.log(arr);
alert(url)
       $.post(url,{data:arr},function(d) {
		              alert(d);
				$("#dd").html(d);	  						   
					                 }).fail(function(x) {
    alert( "error"+x );
  })

});
});
