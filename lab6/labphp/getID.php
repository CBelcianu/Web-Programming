<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'wp1');

    $name = $_GET['name'];
    $query = "SELECT ID FROM product WHERE `Name`='$name'";
    $result = mysqli_query($connection,$query);
    $k=1;
    while($row = mysqli_fetch_array($result)){ 
        $result1[$k]=$row['ID'];
        echo $result1[$k];
        $k=$k+1;
    }
    mysqli_close($connection); 
?>