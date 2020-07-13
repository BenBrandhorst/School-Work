<?php
$target = "fileuploads/";
$target = $target . basename( $_FILES['upload']['name']);

// Move the uploaded file to the new location.
if(move_uploaded_file($_FILES['upload']['name'], $target))
{
echo "Your file was uploaded successfully.";
}
else
{
echo "There was an error in uploading your file.";
}

?> 