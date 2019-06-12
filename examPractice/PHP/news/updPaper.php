<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'newsDB');

    $title = $_GET['title'];
    $textof = $_GET['textof'];
    $category = $_GET['category'];
    $producer = $_GET['producer'];
    $date = $_GET['date'];

    $query = "UPDATE news SET textof='$textof', category='$category', producer='$producer', `date`='$date' WHERE title='$title'";
    $result = mysqli_query($connection,$query);
    
    mysqli_close($connection);
?>