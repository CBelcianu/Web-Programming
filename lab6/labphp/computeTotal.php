<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'wp1');

    $query = "SELECT SUM(`product`.Price) AS 'Total' FROM product INNER JOIN cart on ID=ProductID";
    $result = mysqli_query($connection,$query);
    $row = mysqli_fetch_array($result);
    $result1=$row['Total'];
    echo $result1;
     
    mysqli_close($connection);
?>