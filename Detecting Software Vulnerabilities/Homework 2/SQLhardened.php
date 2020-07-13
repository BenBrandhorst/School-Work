<?php

// Connect to example database
$connect = new mysqli('localhost', 'root', '');
// Check connection
if ($connect->connect_error) {
    die("Connection failed: " . mysqli_error($connect));
}
$select_db = mysqli_select_db($connect, 'SDEV325_Demo');
if (!$select_db) {
    die("Database Selection Failed" . mysqli_error($connect));
}
//prepare and bind
$stmt = $connect->prepare("SELECT * FROM UMUC WHERE student = ? AND class = ?");
$stmt->bind_param("ii", $student, $class);

//set parameters and execute
$student = $_POST[studentid];
$class   = $_POST[classnum];
$stmt->execute();


$stmt->close();
$conn->close();

?> 