<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'wp1');

    $cat = $_GET['cat'];
    if($cat=='none')
        $query = "SELECT * FROM product";
    else $query = "SELECT * FROM product WHERE Category='$cat'";
    $result = mysqli_query($connection,$query);

    $nr = $_GET['nr'];
    $sc = $nr%4;
    
    $k=1;

    while($row = mysqli_fetch_array($result)){
        $result1[$k]=$row['Name']."#".$row['Category']."#".$row['Price']."#".$row['Quantity'];
        /*if($k<=$nr-2 && $k>=$nr-5){
            echo $result1[$k].";";
        }*/
        if($k<=$nr-$sc && $k>=$nr-$sc-3){
            echo $result1[$k].";";
        }
        $k=$k+1;
    }
    
    mysqli_close($connection); 
?>