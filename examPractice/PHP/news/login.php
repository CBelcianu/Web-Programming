  <?php
    $connection = mysqli_connect('localhost', 'root', '');
    mysqli_select_db($connection,'newsDB');

    $username = $_GET['username'];
    $password = $_GET['password'];

    $query = "SELECT username FROM users WHERE username='$username' AND password='$password'";
    $result = mysqli_query($connection,$query);
    $row = mysqli_fetch_array($result);
    $result1=$row['username'];
    echo $result1;
     
    mysqli_close($connection);
?>