<?php
$student = $_POST[studentid];
$class   = $_POST[classnum];
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

$sql = "SELECT * FROM UMUC WHERE student = '$student' AND class = '$class'";

?> 