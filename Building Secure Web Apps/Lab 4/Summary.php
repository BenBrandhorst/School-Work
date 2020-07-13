

<!--
   Date: Jun 15, 2019
   Author: Ben Brandhorst
   Title: Summary.php
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
<body>
<h1>Desert Coffee Roasters</h1>
<?php 
 session_start(); 
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
<h2> Thank you for your comments <?php echo $_COOKIE["name"]; ?>. </h2>
<table border ='1'>
<tr>
      <th><strong> Project</strong></th>
      <th><strong> % Complete</strong></th>
      <th><strong> Comments</strong></th>
   </tr>
   <tr>
      <td> <strong>Establish 1,000 lbs Single Origin Coffee Plantation Delivery from Honduras:</strong><br> We continue to work with local farmers to produce beans from Honduras. We are currently at 400 lbs delivered.</td>
      <td style="text-align:center">40%</td>
      <td> <?php if (strlen(trim($_POST['1st_Project']))) {
         echo $_POST['1st_Project'];
         echo " <br><strong>Submitted:</strong> ";
         echo date("M,d,Y h:i A"); 
                }
          ?> </td>
   </tr>
   <tr>
      <td> <strong>Repair Coffee Roaster #3:</strong><br> Coffee Roaster #3 malfunction identified as faulty heating element. New element is being manufactured. </td>
      <td style="text-align:center">10%</td>
      <td> <?php if (strlen(trim($_POST['2nd_Project']))) {
         echo $_POST['2nd_Project'];
         echo " <br><strong>Submitted:</strong> ";
         echo date("M,d,Y h:i A"); 
                }  ?> </td>
   </tr>
   <tr>
      <td><strong> Design New Coffee Cup Logo:</strong><br> Coffee Cup Logo is in the final revision stages before being sent to manufacturer. </td>
      <td style="text-align:center">85%</td>
      <td> <?php if (strlen(trim($_POST['3rd_Project']))) {
         echo $_POST['3rd_Project'];
         echo " <br><strong>Submitted:</strong> ";
         echo date("M,d,Y h:i A"); 
                }  ?> </td>
   </tr>
   <tr>
      <td><strong> Increase Milk Deliveries to Temecula Coffee Shop to Three Times a Week:</strong><br> In second round of negotiations with local dairy farmers on delivery fees for milk.</td>
      <td style="text-align:center">60%</td>
      <td> <?php if (strlen(trim($_POST['4th_Project']))) {
         echo $_POST['4th_Project'];
         echo " <br><strong>Submitted:</strong> ";
         echo date("M,d,Y h:i A"); 
                }?> </td>
   </tr>
   <tr>
      <td><strong> Decrease Caffeine Content of Decaf Coffee:</strong><br> We honestly don't even know where to begin with this. We tried straining the brewed coffee but it had no impact on caffeine content.</td>
      <td style="text-align:center">0%</td>
      <td> <?php if (strlen(trim($_POST['5th_Project']))) {
         echo $_POST['5th_Project'];;
         echo " <br><strong>Submitted:</strong> ";
         echo date("M,d,Y h:i A"); 
                }?> </td>
   </tr>
   <tr>
      <td><strong> Open Fallbook California Coffee Shop Location:</strong><br> Property for new coffee shop location purchased and initial plans for building designed.</td>
      <td style="text-align:center">25%</td>
      <td> <?php if (strlen(trim($_POST['6th_Project']))) {
         echo $_POST['6th_Project'];
         echo " <br><strong>Submitted:</strong> ";
         echo date("M,d,Y h:i A"); 
                }?> </td>
   </tr>
   <tr>
      <td><strong> Produce 10,000 12 ounce Coffee Bags:</strong><br> Coffee bag production currently at 9,500.</td>
      <td style="text-align:center">95%</td>
      <td> <?php if (strlen(trim($_POST['7th_Project']))) {
         echo $_POST['7th_Project'];
         echo " <br><strong>Submitted:</strong> ";
         echo date("M,d,Y h:i A"); 
                }?> </td>
   </tr>
   <tr>
      <td><strong> Develop New Sugarcane Coffee Stir Sticks:</strong><br> Continuing testing into making sugarcane sticks last longer when exposed to hot liquid.</td>
      <td style="text-align:center">70%</td>
      <td> <?php if (strlen(trim($_POST['8th_Project']))) {
         echo $_POST['8th_Project'];
         echo " <br><strong>Submitted:</strong> ";
         echo date("M,d,Y h:i A"); 
                }?> </td>
   </tr>
   <tr>
      <td><strong> Order 5,000 Summer Style T-Shirts:</strong><br> T-Shirts scheduled for delivery on July 6th 2019.</td>
      <td style="text-align:center">100%</td>
      <td> <?php if (strlen(trim($_POST['9th_Project']))) {
         echo $_POST['9th_Project'];
         echo " <br><strong>Submitted:</strong> ";
         echo date("M,d,Y h:i A"); 
                }?> </td>
   </tr>
   <tr>
      <td><strong> Conduct Profit Analysis on All 5 Coffee Shop Locations:</strong><br> Lake Elsinor profit analysis completed. Now working on Temecula analysis.</td>
      <td style="text-align:center">30%</td>
      <td> <?php if (strlen(trim($_POST['10th_Project']))) {
         echo $_POST['10th_Project'];
         echo " <br><strong>Submitted:</strong> ";
         echo date("M,d,Y h:i A"); 
                }?> </td>
   </tr>
   
  
</table>
</body>
</html>