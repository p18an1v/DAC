$(document).ready(function(){ 
   
     var jVal = { 
         'fullName' : function() { 
   
             $('#sp1').append('<span id="nameInfo" class="info"></span>'); 
   
             var nameInfo = $('#nameInfo'); 

             var ele = $('#fullname'); 
   

   

             if(ele.val().length < 6) { 

                 jVal.errors = true; 

                     nameInfo.removeClass('correct').addClass('error').html('&larr; at least 6 characters').show(); 

                     ele.removeClass('normal').addClass('wrong'); 

             } else { 

                     nameInfo.removeClass('error').addClass('correct').html('&radic;').show(); 

                     ele.removeClass('wrong').addClass('normal'); 

             } 

         }, 

   

         'birthDate' : function (){ 

   

             $('#sp2').append('<span id="birthInfo" class="info"></div>'); 

   

             var birthInfo = $('#birthInfo'); 

             var ele = $('#birthday'); 

             

             var patt = /^[0-9]{2}\-[0-9]{2}\-[0-9]{4}$/i; 

   

             if(!patt.test(ele.val())) { 

                 jVal.errors = true; 

                     birthInfo.removeClass('correct').addClass('error').html('&larr; type in date in correct format').show(); 

                     ele.removeClass('normal').addClass('wrong'); 

             } else { 

                     birthInfo.removeClass('error').addClass('correct').html('&radic;').show(); 

                     ele.removeClass('wrong').addClass('normal'); 

             } 

         }, 

   

         
         'sendIt' : function (){ 
             if(!jVal.errors) { 
				alert(jVal.errors);
                 $('#jform').submit(); 

            } 

         } 

     }; 

   

 // ====================================================== // 

   

     $('#send').click(
	
		 function (){ 
	          jVal.errors = false; 

             jVal.fullName(); 
alert(jVal.errors);
             jVal.birthDate(); 

             jVal.sendIt(); 


        //return false; 

     }); 

   

     $('#fullname').change(jVal.fullName); 

    $('#birthday').change(jVal.birthDate); 

     

 }); 
