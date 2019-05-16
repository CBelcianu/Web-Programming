<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'wp1');

    $query = "SELECT `product`.`Name`,`product`.Price,`product`.Category,`cart`.Quantity 
    FROM product INNER JOIN cart on ID=ProductID";
    $result = mysqli_query($connection,$query);


    $k=0;

    while($row = mysqli_fetch_array($result)){
        $result1[$k]=$row['Name']."#".$row['Category']."#".$row['Price']."#".$row['Quantity'];
        echo $result1[$k].";";
        $k=$k+1;
    }
    
    mysqli_close($connection);
?>