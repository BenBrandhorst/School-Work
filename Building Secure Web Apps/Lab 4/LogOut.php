

<!--
   Date: Jun 15, 2019
   Author: Ben Brandhorst
   Title: LogOut.php
   Description: SDEV300 Lab 4
   -->
<html>
   <head>
      <meta charset="UTF-8">
      <title>Logout Page</title>
   </head>
   <style> 
      input[type=submit] {
      background-color: #000000;
      border: none;
      color: white;
      padding: 16px 32px;
      text-decoration: none;
      margin: 4px 2px;
      cursor: pointer;
      width: 300px;
      height: 40px;
      }
   </style>
   
   <?php
   $username = $_POST["username"];
      session_start();
      if(!isset($_COOKIE["name"])) {
   					header("Location: LogIn.html");
   				}
		 setcookie("name" ,$username, time()-1800, '/');
      ?>
   <h1> Thank You For Visiting Desert Coffee Roasters </h1>
   <h2> You Have Been Logged Out  </h2>
   <form name='login' method='post' action='LogIn.html'>
      <input type="submit" value="Login Again?">
   </form>
   </body>
</html>

