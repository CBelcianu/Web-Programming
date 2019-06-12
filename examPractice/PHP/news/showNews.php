<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'newsDB');
    $query = "SELECT * FROM news";
    $result = mysqli_query($connection,$query);
    $k=0;
    while($row = mysqli_fetch_array($result)){
        $result1[$k]=$row['title']."#".$row['producer']."#".$row['category']."#".$row['date'];
        echo $result1[$k].";";
        $k=$k+1;
    }
    
    mysqli_close($connection);
?>