<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'cars');

    $model = $_GET['model'];
    $hp = $_GET['hp'];
    $hp1 = (int)$hp;
    $torque = $_GET['torque'];
    $torque1 = (int)$torque;
    $fuel = $_GET['fuel'];
    $color = $_GET['color'];
    $price = $_GET['price'];
    $price1 = (int)$price;

    $query = "DELETE FROM car WHERE model='$model' AND hp=$hp1 AND torque=$torque1 AND fuel='$fuel' AND color='$color'";
    $result = mysqli_query($connection,$query);
    
    mysqli_close($connection);
?>