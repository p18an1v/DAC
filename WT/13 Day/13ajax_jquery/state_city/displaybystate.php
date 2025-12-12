
<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "state";
$f=$_POST['data'];
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT city FROM state_city where state ='".$f."'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
	echo "<select>";
	echo "<option>Select</option>";
    while($row = $result->fetch_assoc()) {
        echo "<option>".$row['city']."</option>";
		
    }
	echo "</select>";
} else {
    echo "0 results";
}
$conn->close();
?>

