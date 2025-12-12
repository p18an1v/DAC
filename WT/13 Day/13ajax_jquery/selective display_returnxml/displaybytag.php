<?php
$nm=$_REQUEST['data']['nm'];

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

$sql = "SELECT id, firstname, lastname FROM MyGuests where firstname='$nm'";
$result = $conn->query($sql);

    // output data of each row
    
header ('Content-type: text/xml');
echo "<?xml version='1.0' encoding='ISO-8859-1'?>";
echo "<person>";

while($row = $result->fetch_assoc())
  {  echo "<age>" . $row['id'] ."</age>";
  echo "<firstname>" .$row['firstname'] . "</firstname>";  
 echo "<lastname>" .	$row['lastname']."</lastname>";

  }
echo "</person>";
$conn->close();
?>
