<html>
   <head>
      <meta charset="UTF-8">
      <title>Logout Page</title>
   </head>
>
   
   <?php
   $username = $_POST["id"];
      session_start();
      if(!isset($_SESSION['appUsername'])) {
					header("Location: Login.html");
   				}
	if($_SESSION['timestamp'] < time()-$_SESSION['exp-time']){
// Destroy the session.
session_destroy();
session_unset();
setcookie("userdata" ,$data, time()-1800, '/');
header('Location: http://localhost/SDEV300/Login.html');
} else {
$_SESSION['timestamp'] = time();
}
      ?>
  
   </form>
   </body>
</html>