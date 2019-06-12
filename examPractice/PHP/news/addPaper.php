<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'newsDB');

    $title = $_GET['title'];
    $textof = $_GET['textof'];
    $category = $_GET['category'];
    $producer = $_GET['producer'];
    $date = $_GET['date'];

    $query = "INSERT INTO news(title,textof,category,producer,date) VALUES ('$title','$textof','$category','$producer','$date')";
    $result = mysqli_query($connection,$query);
    
    mysqli_close($connection);
?>