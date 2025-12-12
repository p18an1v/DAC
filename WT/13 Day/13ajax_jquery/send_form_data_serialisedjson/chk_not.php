
<?php
$nm=$_POST["data"]["nm"];
$ps=$_POST["data"]["pass"];

  
  $doc=simplexml_load_file("a.xml");
  $id = $doc->iden;
  $pas = $doc->pass;
 //print_r($doc);
 $flag=0;
foreach ($id as $v) 
 {	 if($v==$nm)
	 { $flag=1;
		 foreach ($pas as $p)
		 {
			 if($p==$ps)
			 { $flag++; break;}
		 }
		  
	 }
	 
 }
 
  if($flag==2)
  {   
        $r=array ("k"=>true);
		$x=json_encode($r);
		 echo $x;
  }
		
		else
		{
		$r=array ("k"=>false);
		 
		        $x=json_encode($r);
		   echo $x;
        }
  
  
?>