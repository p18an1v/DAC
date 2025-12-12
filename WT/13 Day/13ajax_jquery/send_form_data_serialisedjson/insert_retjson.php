<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "myDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$nm=$_POST["data"]["nm"];
$ps=$_POST["data"]["pass"];

// prepare and bind
$stmt = $conn->prepare("INSERT INTO MyGuests (firstname, lastname) VALUES (?, ?)");

/*The "sss" argument lists the types of data that the parameters are. The s character tells mysql that the parameter is a string.

The argument may be one of four types:

i - integer
d - double
s - string
b - BLOB*/

$stmt->bind_param("ss", $firstname, $lastname);

// set parameters and execute
$firstname = $nm;
$lastname = $ps;

$flag=$stmt->execute();

$stmt->close();
$conn->close();

if($flag==true)
  {   
        $r=array("k"=>true);
		$x=json_encode($r);
		 echo $x;
  }
		
		else
		{
		$r=array("k"=>false);
		 
		        $x=json_encode($r);
		   echo $x;
        }
?>