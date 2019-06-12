<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'vacation');

    $city = $_GET['city'];
    $country = $_GET['country'];
    $description = $_GET['description'];
    $cost = $_GET['cost'];
    $cost1 = (int)$cost;

    $query = "UPDATE dest SET description='$description', cost=$cost WHERE city='$city' and country='$country'";
    $result = mysqli_query($connection,$query);
    
    mysqli_close($connection);
?>