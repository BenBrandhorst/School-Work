<?php

require_once 'DBconnect.php';
$randomtoken = base64_encode( openssl_random_pseudo_bytes(32));
// Retrieve Post Data
	$username = $_POST["id"];
	$password = $_POST["pass"];	
	
				// Set the session information
				session_start();  
				$_SESSION['appUsername'] = $username; 
				$_SESSION['appPassword'] = $password;
				$_SESSION['exp-time'] = 30*60;
				$_SESSION[‘csrfToken’]=$randomtoken;
				if(!isset($_SESSION['appUsername'])) {
					header("Location: Login.html");
				}
				?>
<form name='login' method='post' action='LogIn.html'>
   <input type="submit" value="Login">
</form>
<form name='logout' method='post' action='LogOut.php'>
   <input type="submit" value="Logout">
</form>
<?php
// Call cookie saver
saveLogin($username, $password);

echo "Welcome to our App " . $username;

echo "<p> </p>";

$val = connectDB();

// Ask if they want to view the sample config file
echo "Enter the sample config file to be view";
?>
<form name='view form' method='post' action='Deleteme.php'>
<tr> <td>Filename (e.g. sampleconfig.dat):</td>
<td><input name='configdata' type='text' size='50'></td> </tr>
<tr> <td colspan='2' align='center'><input name='btnsubmit' type='submit' value='Submit'></td> </tr>
<input type=’hidden’ name=’csrfToken’ value='<?php echo($_SESSION[‘csrfTOken’]) ?>’ />
</table> </form>
<?php

// Function to store the cookies for later use
function saveLogin($id, $pass){
   $data = $id . ',' . $pass;
   setcookie ("userdata", $data);
}


?>