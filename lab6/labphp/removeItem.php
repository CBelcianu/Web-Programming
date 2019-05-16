<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'wp1');

    $uid = $_GET['uid'];
    $uid1 = (int)$uid;

    $quant = "SELECT Quantity FROM cart WHERE ProductID=$uid1";
    $res = mysqli_query($connection,$quant);
    $row = mysqli_fetch_array($res);
    $quant1 = $row['Quantity'];
    $query = "DELETE FROM cart WHERE ProductID=$uid1";
    $query1 = "UPDATE product SET Quantity=Quantity+$quant1 WHERE ID=$uid1";
    $result = mysqli_query($connection,$query);
    $result1 = mysqli_query($connection,$query1);

    mysqli_close($connection);
?>