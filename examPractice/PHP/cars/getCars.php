<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'cars');
    $query = "SELECT * FROM car";
    $result = mysqli_query($connection,$query);
    $k=0;
    while($row = mysqli_fetch_array($result)){
        $result1[$k]=$row['model']."#".$row['hp']."#".$row['torque']."#".$row['fuel']."#".$row['color']."#".$row['price'];
        echo $result1[$k].";";
        $k=$k+1;
    }
    
    mysqli_close($connection);
?>