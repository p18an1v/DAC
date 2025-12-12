$(document).ready(function(){
	var c=0;

  $("#btn").click(function(){
//var n=$("#nm").val(); do not use this way
//var p= $("#pas").val();

arr=$("#frm").serializeJSON();
console.log(arr)
var url="insert_retjson.php";
console.log(arr);
alert(url)
       $.post(url,{data:arr},function(d) {
		              alert(d);
//JSON.parse() to convert text into a JavaScript object:
					  var y= $.parseJSON(d);
					   alert(y.k);
                     if(y.k==false)
					 $('#dd').html("result="+y.k);
					  
					   else 
					   {window.location="welcome.html"
						   
						   //$('#dd').html("result="+y.k);
						   }
					   
					   
					  
                }).fail(function(x) {
    alert( "error"+x );
  })

});
});
