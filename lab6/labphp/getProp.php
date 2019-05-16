<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'wp1');

    $prop=$_GET['prop'];

    $query = "SELECT DISTINCT $prop FROM product";
    $result = mysqli_query($connection,$query);
    
    while($row = mysqli_fetch_array($result)){
        echo $row[$prop];
        echo "#";
    }
    
    mysqli_close($connection);
?>