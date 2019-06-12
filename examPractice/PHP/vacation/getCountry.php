<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'vacation');
    $prop=$_GET['prop'];
    $query = "SELECT DISTINCT $prop FROM dest";
    $result = mysqli_query($connection,$query);
    
    while($row = mysqli_fetch_array($result)){
        echo $row[$prop];
        echo "#";
    }
    
    mysqli_close($connection);
?>