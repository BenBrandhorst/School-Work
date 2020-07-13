

<?php
   $target = "fileuploads/";
   $target = $target . basename( $_FILES['upload']['name']);
   $uploadCleared = 0;
   //returns only the final extension if file has more than one extension
   $imageFile = pathinfo($target,PATHINFO_EXTENSION);
   
   // Allow certain file formats
   $fileTypeArray = array(IMAGETYPE_GIF, IMAGETYPE_JPEG, IMAGETYPE_PNG);
   $exifImageType = (exif_imagetype($imageFile));
   if (!in_array($exifImageType, $fileTypeArray, false))
   {
       echo 'The image is not a gif, jpeg, or png file. Please convert your file 
       to a supported format and try again.';
       $uploadCleared = 0;
   }
       else {
       $uploadCleared = 1;
   }
   
   // Check file size
   if ($_FILES['upload']['name'] > 26214400) {
       echo "Sorry, your file is larger than 25 megabytes. Please reduce the file size and try again.";
       $uploadCleared = 0;
   }
   
   
   // Check if $uploadCleared is set to 0 by an error
   if ($uploadCleared == 0) {
       echo "There was an error and your file wasn't uploaded";
   // Otherwise try uploading the file
   } else {
       if (move_uploaded_file($_FILES['upload']['name'], $target)) {
           echo "The file ". basename( $_FILES['upload']['name']). " has been uploaded.";
       } else {
           echo "File upload error. Please try again.";
       }
   }
   ?>

