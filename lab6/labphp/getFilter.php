<?php
    $connection = mysqli_connect('localhost', 'root', ''); //The Blank string is the password
    mysqli_select_db($connection,'problem6');

    $prop=$_GET['prop'];
    $value=$_GET['value'];

    //$result1='';
    
    $query = "SELECT * FROM laptops WHERE $prop='$value'"; //You don't need a ; like you do in SQL
    $result = mysqli_query($connection,$query);
    
    
    #$result1=$result1."<table>"; // start a table tag in the HTML
    
    while($row = mysqli_fetch_array($result)){   //Creates a loop to loop through results
    #$result1=$result1. "<tr><td>" . $row['Plecare'] ."</td><td>" . $row['Sosire'] ."</td></tr>";  //$row['index'] the index here is a field name
    echo $row['Nume'];
    echo ";";
    echo $row['Producator'];
    echo ";";
    echo $row['Procesor'];
    echo ";";
    echo $row['PlacaVideo'];
    echo "#";
    }
    
    #$result1=$result1."</table>"; //Close the table in HTML
    
    //echo $result1;
    
    #echo $result1;
    mysqli_close($connection);



?>