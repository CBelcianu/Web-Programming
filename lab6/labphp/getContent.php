<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'wp1');

    $query = "SELECT * FROM product";
    $result = mysqli_query($connection,$query);
    
    while($row = mysqli_fetch_array($result)){
        echo $row['Name'];
        echo ";";
        echo $row['Category'];
        echo ";";
        echo $row['Price'];
        echo ";";
        echo $row['Quantity'];
        echo "#";
    }

    mysqli_close($connection);
?>