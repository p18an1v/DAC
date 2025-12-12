$(document).ready(function(){
	
  $("#sl").change(function(){
var n=$("#sl option:selected").val();



var arr = {"nm" : n};
var url="displaybytag.php";
console.log(arr);
alert(url)
       $.post(url,{data:arr},function(d) {
		              alert(d);
	
  
					                 }).fail(function(x) {
    alert( "error"+x );
  })

});
});
