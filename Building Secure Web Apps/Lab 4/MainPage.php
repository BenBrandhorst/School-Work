

<!--
   Date: Jun 15, 2019
   Author: Ben Brandhorst
   Title: MainPage.php
   Description: SDEV300 Lab 4
   -->
<!DOCTYPE html>
<meta charset="UTF-8">
<head>
   <title>Desert Coffee Roasters </title>
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
<h1>Desert Coffee Roasters</h1>
<?php 
   // Retrieve Post Data
   $username = $_POST["username"];
   $email = $_POST["email"];
   $pass = $_POST["pass"];
   setcookie("name" ,$username, time()+1800, '/');
  if(!isset($_COOKIE["name"])) {
   					header("Location: LogIn.html");
   				}
			
   	
   
   	?>
<form name='login' method='post' action='LogIn.html'>
   <input type="submit" value="Login">
</form>
<form name='logout' method='post' action='LogOut.php'>
   <input type="submit" value="Logout">
</form>
<h2> Welcome to Desert Coffee Roasters <?php echo $_COOKIE["name"]; ?>. Please add comments in the last column of the<br> table below and press "Submit Comments" when ready to review your comments. </h2>
<table border ='1'>
   <form action="Summary.php" method="post">
   <tr>
      <th><strong> Project</strong></th>
      <th><strong> % Complete</strong></th>
      <th><strong> Comments</strong></th>
   </tr>
   <tr>
      <td style="text-align:center"> Establish 1,000 lbs Single Origin Coffee Plantation Delivery from Honduras </td>
      <td style="text-align:center">40%</td>
      <td> <textarea name="1st_Project" rows="4" cols="50"> </textarea></td>
   </tr>
   <tr>
      <td style="text-align:center"> Repair Coffee Roaster #3 </td>
      <td style="text-align:center">10%</td>
      <td> <textarea name="2nd_Project" rows="4" cols="50"> </textarea></td>
   </tr>
   <tr>
      <td style="text-align:center"> Design New Coffee Cup Logo </td>
      <td style="text-align:center">85%</td>
      <td> <textarea name="3rd_Project" rows="4" cols="50"> </textarea></td>
   </tr>
   <tr>
      <td style="text-align:center"> Increase Milk Deliveries to Temecula Coffee Shop to Three Times a Week</td>
      <td style="text-align:center">60%</td>
      <td> <textarea name="4th_Project" rows="4" cols="50"> </textarea></td>
   </tr>
   <tr>
      <td style="text-align:center"> Decrease Caffeine Content of Decaf Coffee</td>
      <td style="text-align:center">0%</td>
      <td> <textarea name="5th_Project" rows="4" cols="50"> </textarea></td>
   </tr>
   <tr>
      <td style="text-align:center"> Open Fallbook California Coffee Shop Location</td>
      <td style="text-align:center">25%</td>
      <td> <textarea name="6th_Project" rows="4" cols="50"> </textarea></td>
   </tr>
   <tr>
      <td style="text-align:center"> Produce 10,000 12 ounce Coffee Bags</td>
      <td style="text-align:center">95%</td>
      <td> <textarea name="7th_Project" rows="4" cols="50"> </textarea></td>
   </tr>
   <tr>
      <td style="text-align:center"> Develop New Sugarcane Coffee Stir Sticks</td>
      <td style="text-align:center">70%</td>
      <td> <textarea name="8th_Project" rows="4" cols="50"> </textarea></td>
   </tr>
   <tr>
      <td style="text-align:center"> Order 5,000 Summer Style T-Shirts</td>
      <td style="text-align:center">100%</td>
      <td> <textarea name="9th_Project" rows="4" cols="50"> </textarea></td>
   </tr>
   <tr>
      <td style="text-align:center"> Conduct Profit Analysis on All 5 Coffee Shop Locations</td>
      <td style="text-align:center">30%</td>
      <td> <textarea name="10th_Project" rows="4" cols="50"> </textarea></td>
   </tr>
   <tr>
</table>
<?php echo "<form name='Submit' method='post' action='Summary.php'>
   <input name='submit' type='submit' value='Submit Comments'>"; ?>
</body>
</html>

