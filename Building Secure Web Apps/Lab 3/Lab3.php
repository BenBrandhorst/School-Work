

<!--
   Date: Jun 06, 2019
   Author: Ben Brandhorst
   Title: Week3PHP.php
   Description: SDEV300 Lab 3
   -->
<!DOCTYPE html>
<meta charset="UTF-8">
<html>
   <head>
      <title> SDEV 300 Lab 3 Assignment</title>
      <h1>SDEV 300 Lab 3</h1>
   </head>
   <body>
      <h2>Table 1 Math Functions</h2>
      <?php
         function slopeIntercept($x){
         	$m = -2;
         	$b = 0;
         	$y = $m * $x + $b;
         	return $y;
         }
         
         function slopeFormula($x){
         	$z = "y = (-2)($x) + 0";
         	return $z;
         }
         
         function surfaceArea($r){
         	$a = 4 * 3.14159265359 * ($r * $r);
         	return $a;
         }
         
         function surfaceFormula($r){
         	$z = "A = 4&pi;$r<sup>2</sup>";
         	return $z;	
         }
         
         function distance($v,$t){
         	$d = $v * $t;
         	return "d = $d m";	
         }
         ?>
      <!--Math Equation Table using slopeIntercept and surfaceArea functions. -->
      <table border="1">
         <th colspan="2"> Slope intercept equation for a line: y = mx + b</th>
         <tr>
            <td>If
               <?php echo slopeFormula(2); ?>
            </td>
            <td>y =
               <?php echo slopeIntercept(2); ?>
            </td>
         </tr>
         <tr>
            <td>If
               <?php echo slopeFormula(5); ?>
            </td>
            <td>y =
               <?php echo slopeIntercept(5); ?>
            </td>
         </tr>
         <tr>
            <td>If
               <?php echo slopeFormula(8); ?>
            </td>
            <td>y =
               <?php echo slopeIntercept(8); ?>
            </td>
         </tr>
         <tr>
            <td>If
               <?php echo slopeFormula(10); ?>
            </td>
            <td>y =
               <?php echo slopeIntercept(10); ?>
            </td>
         </tr>
         <tr>
            <th colspan="2"> Surface Area of a Sphere: A = 4&pi;R<sup>2</sup></th>
         </tr>
         <tr>
            <td>If
               <?php echo surfaceFormula(2); ?>
            </td>
            <td>A =
               <?php echo surfaceArea(2); ?>
            </td>
         </tr>
         <tr>
            <td>If
               <?php echo surfaceFormula(6); ?>
            </td>
            <td>A =
               <?php echo surfaceArea(6); ?>
            </td>
         </tr>
         <tr>
            <td>If
               <?php echo surfaceFormula(10); ?>
            </td>
            <td>A =
               <?php echo surfaceArea(10); ?>
            </td>
         </tr>
         <tr>
            <td>If
               <?php echo surfaceFormula(100); ?>
            </td>
            <td>A =
               <?php echo surfaceArea(100); ?>
            </td>
         </tr>
         <tr>
            <td>If
               <?php echo surfaceFormula(1000); ?>
            </td>
            <td>A =
               <?php echo surfaceArea(1000); ?>
            </td>
         </tr>
         <tr>
            <th colspan="2"> Distance object travels: d = vt</th>
            <?php
               $timeValue = array(0,.5,1,1.5,2,2.5,3,3.5,4,4.5,5,5.5,6,6.5,7,7.5,8,8.5,9,9.5,10);
               $vel = "velocity:";
               foreach($timeValue as $t){
               	echo "<th>t = $t s </th>";
               }
               echo "</tr>";
                echo "<tr>";
                echo "<td> </td>";
                echo "<th>$vel 10 m/s * t</th>";
               foreach ($timeValue as $t){ 
                  echo "<td>";
                  echo distance($t,10); 			  
                  echo "</td>";  
               } 
               echo "</tr>";
               echo "<tr>"; 
               echo "<td> </td>";
                echo "<th>$vel 30 m/s * t</th>";
               foreach ($timeValue as $t){  
                  echo "<td>";
                  echo distance($t,30); 			  
                  echo "</td>";  
               }
               echo "</tr>";
               echo "<tr>";
                echo "<td> </td>";
                echo "<th>$vel 327 m/s * t</th>";
               foreach ($timeValue as $t){  
                  echo "<td>";
                  echo distance($t,327); 			  
                  echo "</td>"; 
               }
               echo "</tr>";
               echo "<tr>";
                echo "<td> </td>";
                echo "<th>$vel 1200 m/s * t</th>";
               foreach ($timeValue as $t){ 
                  echo "<td>";
                  echo distance($t,1200); 			  
                  echo "</td>"; 
               }
               echo "</tr>";
               ?>
         </tr>
      </table>
      <!-- Table using built in  PHP String functions -->
      <h2>Table 2 String Functions</h2>
      <table border="1">
         <tr>
            <?php 
               $quote = "I can never read all the books I want; I can never be all the people I want and live all the lives I want. I can never train myself in all the skills I want. And why do I want? I want to live and feel all the shades, tones and variations of mental and physical experience possible in my life. And I am horribly limited. Sylvia Plath, The Unabridged Journals of Sylvia Plath";
                $x = 0; 
               
               //calculates size of each word in the $quote string 
               function wordLengths($quote){
                 $lengths = [];
                 foreach ( str_word_count($quote, 1) as $word ) {
                     $lengths[] = strlen($word);
                 }
                 echo implode(",", $lengths);
               }
               // breaks down $quote into an array full of individual words and then shuffles the order of the characters within those words
               function shuffleWord() {
               global $quote;
			   global $x;
               $quoteWords = explode(" ", $quote);
               foreach ($quoteWords as $words){ 
               	$shuffled = str_shuffle($quoteWords[$x]);
               	echo $shuffled;
				$x++;
               echo " ";}}
               ?>
            <th> Modification to Quote</th>
            <th> Quotation </th>
            </td>
         <tr>
            <td> Original Quotation</td>
            <td>
               <?php echo $quote; ?>
            </td>
         </tr>
         <td> Capitalize First Letter Each Word</td>
         <td>
            <?php echo ucwords($quote); ?>
         </td>
         </tr>
         <tr>
            <td> Displays the word length of each word in the quote separated by commas.</td>
            <td>
               <?php echo wordLengths($quote); ?>
            </td>
         </tr>
         <tr>
            <td> Randomly shuffles each word in the quote.</td>
            <td> <?php echo shuffleWord();
               ?></td>
         </tr>
      </table>
   </body>
</html>

