<html>
<head>
<script src="jquery-1.9.1.js"></script>
<script src="ajaxcall.js"></script>

</head>
<body>
<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "state";

$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT DISTINCT(state) FROM state_city";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
	echo "<select id='sl'>";
	echo "<option>Select</option>";
    while($row = $result->fetch_assoc()) {
        echo "<option>".$row['state']."</option>";
		
    }
	echo "</select>";
} else {
    echo "0 results";
}
$conn->close();
?>
<div id="dd">
</div>
</body>
</html>