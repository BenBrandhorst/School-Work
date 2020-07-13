
<form name='login' method='post' action='LogIn.html'>
   <input type="submit" value="Login">
</form>
<form name='logout' method='post' action='LogOut.php'>
   <input type="submit" value="Logout">
</form>
<?php


$file=$_POST['configdata'];
$str=filter_var($file, FILTER_SANITIZE_ENCODED);
echo "About to show this configuration file:" . $str;
echo "<p></p>";


//print "data is " . $newstr;

echo "data is:" . $str;
?>