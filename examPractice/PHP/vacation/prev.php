<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'vacation');
    $cat = $_GET['cat'];
    if($cat=='none')
        $query = "SELECT * FROM dest";
    else $query = "SELECT * FROM dest WHERE country='$cat'";
    $result = mysqli_query($connection,$query);
    $nr = $_GET['nr'];
    $sc = $nr%4;
    
    $k=1;
    while($row = mysqli_fetch_array($result)){
        $result1[$k]=$row['city']."#".$row['country']."#".$row['description']."#".$row['cost'];
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