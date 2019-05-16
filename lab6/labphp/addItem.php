<?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'wp1');

    $queryv = "SELECT DISTINCT ProductID FROM cart";
    $resultV = mysqli_query($connection,$queryv);
    $isok=1;


    $uid = $_GET['uid'];
    $uid1 = (int)$uid;

    while($row = mysqli_fetch_array($resultV)){
        if($uid1==$row['ProductID']) $isok=0;
    }

    if($isok==1){
        $query = "INSERT INTO cart(ProductID,Quantity) VALUES ($uid1,1)";
        $query1 = "UPDATE product SET Quantity=Quantity-1 WHERE ID=$uid1";
        $result = mysqli_query($connection,$query);
        $result1 = mysqli_query($connection,$query1);
    }
    else{
        $query = "UPDATE cart SET Quantity=Quantity+1 WHERE ProductID=$uid1";
        $query1 = "UPDATE product SET Quantity=Quantity-1 WHERE ID=$uid1";
        $result = mysqli_query($connection,$query);
        $result1 = mysqli_query($connection,$query1);
    }
    
    mysqli_close($connection);
?>