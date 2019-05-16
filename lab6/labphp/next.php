<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'wp1');

    $cat = $_GET['cat'];
    if($cat=='none')
        $query = "SELECT * FROM product";
    else $query = "SELECT * FROM product WHERE Category='$cat'";
    $result = mysqli_query($connection,$query);

    $nr = $_GET['nr'];

    $k=0;

    while($row = mysqli_fetch_array($result)){
    $result1[$k]=$row['Name']."#".$row['Category']."#".$row['Price']."#".$row['Quantity'];
    if($k>=$nr && $k<$nr+4){
        echo $result1[$k].";";
    }
    $k=$k+1;
    }
    
    mysqli_close($connection);
?>